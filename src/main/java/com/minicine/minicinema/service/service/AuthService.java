package com.minicine.minicinema.service.service;

import com.minicine.minicinema.dto.LoginRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String login(LoginRequestDto dto);
}