package com.minicine.minicinema.service;

import com.minicine.minicinema.dto.member.CustomMemberDetails;
import com.minicine.minicinema.entity.MemberEntity;
import com.minicine.minicinema.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomMemberDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username으로 검색한 member 값이 없습니다."));

        return new CustomMemberDetails(memberEntity);
    }
}
