package com.minicine.minicinema.service.member;

import com.minicine.minicinema.dto.MemberDto;
import com.minicine.minicinema.entity.MemberEntity;
import com.minicine.minicinema.repository.MemberRepository;
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

    @Override
    public MemberDto findById(Long memberId) {
        MemberEntity memberEntity = memberRepository.findMemberById(memberId);

        return MemberDto.toDto(memberEntity);
    }
}
