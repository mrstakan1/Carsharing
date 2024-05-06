package com.example.carsharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/main")
    public String mainUrl(Model model) {
        return "main";
    }
}
