package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.LoginRequestDto;
import com.minicine.minicinema.jwt.JwtUtil;
import com.minicine.minicinema.repository.member.MemberRepository;
import com.minicine.minicinema.service.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthApiController {

    private final AuthService authService;
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

//    @PostMapping("/signup")
//    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
//        return ResponseEntity.ok(authService.signup(memberRequestDto));
//    }

    @PostMapping("/login")
    public ResponseEntity<String> getMemberProfile(
            @Valid @RequestBody LoginRequestDto request, HttpServletResponse response) throws IOException {

        String token = this.authService.login(request);

        // HTTP-Only 쿠키 설정
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true); // HTTPS에서만 쿠키 전송
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1시간 유효

        response.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}