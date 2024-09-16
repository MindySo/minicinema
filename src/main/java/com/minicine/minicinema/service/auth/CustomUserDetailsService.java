package com.minicine.minicinema.service.auth;

import com.minicine.minicinema.entity.member.MemberEntity;
import com.minicine.minicinema.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberEntity memberEntity = memberRepository.findMemberByUsername(username);

        if (memberEntity != null) {
            return createUserDetails(memberEntity);
        } else {
            throw new UsernameNotFoundException("해당하는 유저가 없습니다.");
        }
    }

    // DB 에 User 값이 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(MemberEntity memberEntity) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(memberEntity.getAuthority().toString());

        return new User(
                String.valueOf(memberEntity.getId()),
                memberEntity.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}