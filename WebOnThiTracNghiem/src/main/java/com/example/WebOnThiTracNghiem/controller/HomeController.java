package com.example.WebOnThiTracNghiem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        return "Home/index";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        return "Admin/Admin";
    }

    @GetMapping("/user")
    public String user(Model model){
        return "Users/User";
    }

    @GetMapping("/403")
    public String AccesDenied(Model model) {
        return "403";
    }

}
