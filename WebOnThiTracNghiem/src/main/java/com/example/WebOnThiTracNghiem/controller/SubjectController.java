package com.example.WebOnThiTracNghiem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SubjectController {
    @GetMapping("/admin/subjects/add")
    public String showAddForm(Model model) {
        return "Subjects/Add-Subject";
    }

    @GetMapping("/admin/subjects/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        return "Subjects/Update-Subject";
    }
}
