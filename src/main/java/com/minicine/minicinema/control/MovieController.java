package com.minicine.minicinema.control;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    @GetMapping("/detailMovie")
    public String detailMovie() {
        return "/detail/detailMovie";
    }
}
