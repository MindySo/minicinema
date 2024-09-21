package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.MovieDto;
import com.minicine.minicinema.dto.member.MemberDto;
import com.minicine.minicinema.jwt.JwtUtil;
import com.minicine.minicinema.service.MovieService;
import com.minicine.minicinema.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final MovieService movieService;
    private final MemberService memberService;
    private final JwtUtil jwtUtil;

    // 로그인 정보 가져오기
    @ModelAttribute
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


    @GetMapping("/")
    public String mainPage(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model) {
        List<MovieDto> movieList = movieService.selectAll();
        model.addAttribute("MovieList", movieList);
        model.addAttribute("loginInfo", loginInfo);
        log.info("loginInfo: {}" , loginInfo);

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

    @GetMapping("/signupSuccess")
    public String signUpSuccess() {
        return "/main/main";
    }



}
