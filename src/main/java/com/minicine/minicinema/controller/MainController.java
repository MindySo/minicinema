package com.minicine.minicinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String main() {
        return "MainController";
    }

    @GetMapping("/admin")
    public String admin() {
        return "AdminController";
    }
}
