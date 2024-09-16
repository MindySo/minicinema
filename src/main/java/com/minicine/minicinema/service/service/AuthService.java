package com.minicine.minicinema.service.service;

import com.minicine.minicinema.dto.MemberRequestDto;
import com.minicine.minicinema.dto.MemberResponseDto;
import com.minicine.minicinema.dto.TokenDto;
import com.minicine.minicinema.dto.TokenRequestDto;
import com.minicine.minicinema.entity.member.MemberEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    MemberEntity signup(MemberRequestDto memberRequestDto);
    TokenDto login(MemberRequestDto memberRequestDto);
    TokenDto reissue(TokenRequestDto tokenRequestDto);
}