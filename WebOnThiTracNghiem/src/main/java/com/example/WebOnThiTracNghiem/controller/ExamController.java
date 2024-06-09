package com.example.WebOnThiTracNghiem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ExamController {
    @GetMapping("/admin/exams/add")
    public String showAddForm(Model model) {
        return "Exams/Add-Exam";
    }
    @GetMapping("/admin/exams/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        return "Exams/Update-Exam";
    }
}
