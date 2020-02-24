package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/user/home")
    public String userHome(Model model){
        model.addAttribute("message","登录后的主页");
        return "user/home";
    }

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("message","登录后的主页");
        return "main";
    }

    @RequestMapping("/home")
    public String home (Model model){
        model.addAttribute("message","主页无需权限即可访问!");
        return "home";
    }
}
