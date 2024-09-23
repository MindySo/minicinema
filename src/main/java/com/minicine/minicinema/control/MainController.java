package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.MovieDto;
import com.minicine.minicinema.dto.auth.MemberRequestDto;
import com.minicine.minicinema.dto.member.MemberDto;
import com.minicine.minicinema.service.MovieService;
import com.minicine.minicinema.service.auth.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final AuthService authService;
    private final AttributeController attributeController;
    private final MovieService movieService;

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, final Model model) {
        attributeController.addAttributes(request, model);
    }

    @GetMapping("/")
    public String mainPage(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model) {
        List<MovieDto> movieList = movieService.selectAll();
        model.addAttribute("MovieList", movieList);
        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("showSearch", "yes");

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

//    @GetMapping("/memberLogout")
//    public String logout(@ModelAttribute("loginInfo") MemberDto loginInfo, Model model) {
//
//        log.info("mainController.logout");
//
//        MemberRequestDto memberRequestDto = new MemberRequestDto();
//        memberRequestDto.setUsername(loginInfo.getUsername());
//        memberRequestDto.setPassword(loginInfo.getPassword());
//        authService.logout(memberRequestDto);
//
//        List<MovieDto> movieList = movieService.selectAll();
//        model.addAttribute("MovieList", movieList);
//        model.addAttribute("showSearch", "yes");
//        return "/main/main";
//    }



}
