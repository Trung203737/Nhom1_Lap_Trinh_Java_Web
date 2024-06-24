package com.example.WebOnThiTracNghiem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("Welcome","Web ôn thi trắc nghiệm");
        model.addAttribute("userName","Nhom1");
        return "Home/index";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("adminName","Admin");
        return "Admin/Admin";
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("userName","Nhom1");
        return "Users/User";
    }

    @GetMapping("/403")
    public String AccesDenied(Model model) {
        return "403";
    }

}
