package com.example.WebOnThiTracNghiem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/subjects")
    public String showSubjectList(Model model){
        return "Subjects/Subjects-List";
    }
    @GetMapping("/admin/exams")
    public String showExamList(Model model){
        return "Exams/Exams-List";
    }
    @GetMapping("/admin/questions")
    public String showQuestionList(Model model){
        return "Questions/Questions-List";
    }


}
