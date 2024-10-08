package com.minicine.minicinema.service.member;

import com.minicine.minicinema.dto.MemberDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    MemberDto findByUsername(String username);
    MemberDto findById(Long memberId);
}
