package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.auth.MemberRequestDto;
import com.minicine.minicinema.dto.auth.TokenDto;
import com.minicine.minicinema.dto.auth.TokenRequestDto;
import com.minicine.minicinema.entity.MemberEntity;
import com.minicine.minicinema.service.auth.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthApiController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberEntity> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }


    @PostMapping("/login")
    public ResponseEntity<TokenDto> getMemberProfile(
            @Valid @RequestBody MemberRequestDto memberRequestDto, HttpServletResponse response) throws IOException {

        TokenDto tokenDto = this.authService.login(memberRequestDto);

        // HTTP-Only 쿠키 설정
        Cookie cookie = new Cookie("jwt", tokenDto.getAccessToken());
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // true 시 HTTPS에서만 쿠키 전송
        cookie.setPath("/");
        cookie.setMaxAge(7200); // 2시간 유효

        response.addCookie(cookie);

        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}