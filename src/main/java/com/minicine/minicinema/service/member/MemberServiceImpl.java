package com.minicine.minicinema.service.member;

import com.minicine.minicinema.dto.member.MemberDto;
import com.minicine.minicinema.entity.member.MemberEntity;
import com.minicine.minicinema.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public MemberDto findByUsername(String username) {
        MemberEntity memberEntity = memberRepository.findMemberByUsername(username);

        return MemberDto.toDto(memberEntity);
    }
}
