package com.example.WebOnThiTracNghiem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class QuestionController {
    @GetMapping("/admin/questions/add")
    public String showAddForm(Model model) {
        return "Questions/Add-Question";
    }
    @GetMapping("/admin/questions/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        return "Questions/Update-Question";
    }
}
