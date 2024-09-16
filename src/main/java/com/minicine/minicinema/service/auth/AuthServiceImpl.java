package com.minicine.minicinema.service.auth;

import com.minicine.minicinema.dto.auth.MemberRequestDto;
import com.minicine.minicinema.dto.auth.TokenDto;
import com.minicine.minicinema.dto.auth.TokenRequestDto;
import com.minicine.minicinema.entity.auth.RefreshTokenEntity;
import com.minicine.minicinema.entity.member.MemberEntity;
import com.minicine.minicinema.jwt.TokenProvider;
import com.minicine.minicinema.repository.auth.RefreshTokenRepository;
import com.minicine.minicinema.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final TokenProvider tokenProvider;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    @Transactional
    public MemberEntity signup(MemberRequestDto memberRequestDto) {
        if (memberRepository.existsByUsername(memberRequestDto.getUsername())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(memberRequestDto.getUsername());
        memberEntity.setPassword(passwordEncoder.encode(memberRequestDto.getPassword()));
        memberEntity.setAuthority(memberRequestDto.getAuthority());
        memberRepository.save(memberEntity);

        return memberRepository.save(memberEntity);
    }

    @Override
    @Transactional
    public TokenDto login(MemberRequestDto memberRequestDto) {

        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        String username = memberRequestDto.getUsername();
        String password = memberRequestDto.getPassword();
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //  authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        //  loadUserByUsername: null체크 포함
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        // 4. RefreshToken 저장
        RefreshTokenEntity refreshTokenEntity = RefreshTokenEntity.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshTokenEntity);

        // 5. 토큰 발급
        return tokenDto;
    }

    @Override
    @Transactional
    public TokenDto reissue(TokenRequestDto tokenRequestDto) {
        // 1. Refresh Token 검증
        if (!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // 2. Access Token 에서 Member ID 가져오기
        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        // 3. 저장소에서 Member ID 를 기반으로 Refresh Token 값 가져옴
        RefreshTokenEntity refreshToken = refreshTokenRepository.findByKey(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        // 4. Refresh Token 일치하는지 검사
        if (!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 5. 새로운 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        // 6. 저장소 정보 업데이트
        RefreshTokenEntity newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        // 토큰 발급
        return tokenDto;
    }

}