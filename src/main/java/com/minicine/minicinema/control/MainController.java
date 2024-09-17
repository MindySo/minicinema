package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.member.MemberDto;
import com.minicine.minicinema.jwt.JwtUtil;
import com.minicine.minicinema.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final JwtUtil jwtUtil;
    private final HttpSession session;
    private final MemberService memberService;

    @GetMapping("/")
    public String mainPage() { return "/main/main"; }

    @GetMapping("/signIn")
    public String login() {
        return "/member/signIn";
    }

    @GetMapping("/signupForm")
    public String signupForm() {
        return "/member/signupForm";
    }


//    // 로그인 정보 가져오기
//    @ModelAttribute
//    public void addAttributes(HttpServletRequest request, Model model) {
//        String token = getTokenFromCookies(request.getCookies());
//        String username = jwtUtil.getUsername(token);
//        log.info("loginUser: {}", username);
//        MemberDto memberDto = memberService.findByUsername(username);
//
//        model.addAttribute("loginInfo", memberDto);
//    }
//
//    private String getTokenFromCookies(Cookie[] cookies) {
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("jwt".equals(cookie.getName())) {
//                    return cookie.getValue();
//                }
//            }
//        }
//        return null;
//    }
//
//    @GetMapping("/loginSuccess")
//    public String loginSuccess(HttpServletRequest request, HttpServletResponse response,
//                               @ModelAttribute("loginInfo") MemberDto loginInfo, Model model) {
//        // 쿠키에서 JWT 토큰을 가져옴
//        String token = getTokenFromCookies(request.getCookies());
//        if (token == null || jwtUtil.isExpired(token)) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return "redirect:/login";
//        }
//
//        // JWT 토큰에서 사용자 정보 추출
//        String username = jwtUtil.getUsername(token);
//        String role = jwtUtil.getRole(token);
//
//        // 사용자 정보를 request에 저장 (필요 시 사용)
//        request.setAttribute("username", username);
//        request.setAttribute("role", role);
//
//        return "/main/main";
//    }

    @GetMapping("/signupSuccess")
    public String signUpSuccess() {
        return "/main/main";
    }



}
