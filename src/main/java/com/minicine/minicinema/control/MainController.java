package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.MovieDto;
import com.minicine.minicinema.dto.member.MemberDto;
import com.minicine.minicinema.service.MovieServiceImple;
import com.minicine.minicinema.service.auth.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final AuthService authService;
    private final AttributeController attributeController;
    private final MovieServiceImple movieService;

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, final Model model) {
        attributeController.addAttributes(request, model);
    }

    @GetMapping("/")
    public String mainPage(@ModelAttribute("loginInfo") MemberDto loginInfo,
                           @PageableDefault(size = 12) Pageable pageable, Model model) {
//        List<MovieDto> movieList = movieService.selectAll();
        Page<Map<String, Object>> movieList = movieService.moviePaging(pageable);

        log.info("movieList: {}", movieList);

        model.addAttribute("movieList", movieList);
        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("showSearch", "yes");

        // 페이지네이션에 필요한 정보
//        return getPageInfoAndGoView(model, notepads, "admin/notepad/list");
        return "/main/main";
    }

//    @GetMapping("getPageInfoAndGoView")
//    public ResponseEntity<?> getListBoard(List<MovieDto> movieDto, @PageableDefault(size = 10) Pageable pageable) {
//        return ResponseEntity.ok(movieService.moviePaging(movieDto, pageable));
//    }

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
