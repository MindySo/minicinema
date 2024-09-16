package com.minicine.minicinema.service.auth;

import com.minicine.minicinema.dto.auth.MemberRequestDto;
import com.minicine.minicinema.dto.auth.TokenDto;
import com.minicine.minicinema.dto.auth.TokenRequestDto;
import com.minicine.minicinema.entity.member.MemberEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    MemberEntity signup(MemberRequestDto memberRequestDto);
    TokenDto login(MemberRequestDto memberRequestDto);
    TokenDto reissue(TokenRequestDto tokenRequestDto);
}