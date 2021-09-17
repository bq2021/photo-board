package com.bq.continues.photo.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @GetMapping("main")
    public String mainPageController(Model model) {
        model.addAttribute("title", "메인페이지");
        model.addAttribute("intro", "thymeleaf 학습을 위하여 만든 프로젝트 입니다.");
        return "main";
    }

}
