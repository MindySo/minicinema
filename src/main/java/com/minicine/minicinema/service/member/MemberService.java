package com.minicine.minicinema.service.member;

import com.minicine.minicinema.dto.member.MemberDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    MemberDto findByUsername(String username);
}
