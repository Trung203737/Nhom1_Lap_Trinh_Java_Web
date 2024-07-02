package com.example.WebOnThiTracNghiem.controller;


import com.example.WebOnThiTracNghiem.model.Exam;
import com.example.WebOnThiTracNghiem.model.Subject;
import com.example.WebOnThiTracNghiem.repository.ExamRepository;
import com.example.WebOnThiTracNghiem.service.ExamService;
import com.example.WebOnThiTracNghiem.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @Autowired
    private final ExamService examService;
    @Autowired
    private final SubjectService subjectService;
    @Autowired
    private ExamRepository examRepository;

    @GetMapping("/")
    public String home(Model model){
        List<Exam> exams = examService.getAllExams();
        model.addAttribute("exams", exams);
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "Home/index";
    }

    @GetMapping("/subjects/quizs/{id}")
    public String showQuizBySubject(@PathVariable("id") Long id, Model model){
        List<Exam> exams = examService.getExamsByIdSubject(id);
        model.addAttribute("exams", exams);
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);

        return "Home/List-Quiz-By-Subject";
    }

    @PostMapping("/searchBySubject")
    public String searchBySubject(@RequestParam String subjectName, Model model) {
        List<Exam> exams = examRepository.findBySubjectName(subjectName);
        model.addAttribute("exams", exams);
        return "Home/index"; // Thay đổi tên template theo cấu trúc của bạn
    }

    // Xử lý tìm kiếm theo tên bài thi
    @PostMapping("/searchByNote")
    public String searchByNote(@RequestParam String note, Model model) {
        List<Exam> exams = examRepository.findByNoteContaining(note);
        model.addAttribute("exams", exams);
        return "Home/index"; // Thay đổi tên template theo cấu trúc của bạn
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
