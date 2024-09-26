package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.member.MemberDto;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.minicine.minicinema.jwt.JwtUtil;
import com.minicine.minicinema.service.member.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;


@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class AttributeController {
    private final MemberService memberService;
    private final JwtUtil jwtUtil;

    public void addAttributes(HttpServletRequest request, Model model) {
        String token = getTokenFromCookies(request.getCookies());
        log.info("token : {}", token);
        MemberDto memberDto = null;
        if(token != null) {
            String username = jwtUtil.getUsername(token);
            log.info("username: {}", username);
            memberDto = memberService.findByUsername(username);
        }
        model.addAttribute("loginInfo", memberDto);
    }

        private String getTokenFromCookies(Cookie[] cookies) {
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("jwt".equals(cookie.getName())) {
                        return cookie.getValue();
                    }
                }
            }
            return null;
        }
}
