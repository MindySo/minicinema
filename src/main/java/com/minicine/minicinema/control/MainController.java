package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.MovieDto;
import com.minicine.minicinema.dto.member.MemberDto;
import com.minicine.minicinema.jwt.JwtUtil;
import com.minicine.minicinema.service.MovieService;
import com.minicine.minicinema.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final JwtUtil jwtUtil;
    private final HttpSession session;
    private final MovieService movieService;

    @GetMapping("/")
    public String mainPage(Model model) {
        List<MovieDto> MovieList = movieService.selectAll();
        model.addAttribute("MovieList", MovieList);

        return "/main/main";
    }

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
//
//
//        return "/main/main";
//    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(HttpServletRequest request, HttpServletResponse response,
                               @AuthenticationPrincipal User user, Model model) {

        log.info("user {}:" + user, user.getUsername());

        return "/main/main";
    }

    @GetMapping("/signupSuccess")
    public String signUpSuccess() {
        return "/main/main";
    }



}
