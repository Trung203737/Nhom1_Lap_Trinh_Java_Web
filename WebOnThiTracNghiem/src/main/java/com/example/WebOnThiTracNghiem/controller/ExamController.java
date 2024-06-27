package com.example.WebOnThiTracNghiem.controller;

import com.example.WebOnThiTracNghiem.model.Exam;
import com.example.WebOnThiTracNghiem.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExamController {
    @Autowired
    private final ExamService examService;
    @GetMapping("/admin/exams/add")
    public String showAddForm(Model model) {
        return "Exams/Add-Exam";
    }
    @GetMapping("/admin/exams/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        return "Exams/Update-Exam";
    }
    @GetMapping("/exam/{id}")
    public String showTestForm(@PathVariable Long id,Model model) {
        Exam exam=examService.loadExamById(id);
        model.addAttribute("exam",exam);
        return "Exams/Test";
    }

}
