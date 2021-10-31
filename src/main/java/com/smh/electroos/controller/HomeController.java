package com.smh.electroos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("classActiveLogin", true);
        return "auth/login";
    }

    @GetMapping("/newUser")
    public String register(Model model){
        model.addAttribute("classActiveNewAccount",true);
        return "auth/register";
    }

    @GetMapping("/forgetPassword")
    public String forgetPassword(Model model){
        model.addAttribute("classActiveForgetPassword",true);
        return "auth/forgetPassword";
    }
}
