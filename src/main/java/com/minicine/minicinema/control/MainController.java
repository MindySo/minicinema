package com.minicine.minicinema.control;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class MainController {

    @GetMapping("/signIn")
    public String login() {
        return "/member/signIn";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "/member/successPage";
    }

    @GetMapping("/main")
    public String main() {
        return "MainController";
    }

    @GetMapping("/admin")
    public String admin() {
        return "AdminController";
    }

    @GetMapping("/main/user")
    public String user() {
        return "UserController";
    }
}
