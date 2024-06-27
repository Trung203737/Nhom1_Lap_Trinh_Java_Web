package com.example.WebOnThiTracNghiem.controller;


import com.example.WebOnThiTracNghiem.model.Exam;
import com.example.WebOnThiTracNghiem.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @Autowired
    private final ExamService examService;

    @GetMapping("/")
    public String home(Model model){
        List<Exam> exams = examService.getAllExams();
        model.addAttribute("exams", exams);
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
