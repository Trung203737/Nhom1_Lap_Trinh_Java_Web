package com.example.WebOnThiTracNghiem.controller;

import com.example.WebOnThiTracNghiem.model.*;
import com.example.WebOnThiTracNghiem.repository.AccountExamRepository;
import com.example.WebOnThiTracNghiem.repository.ExamRepository;
import com.example.WebOnThiTracNghiem.repository.IAccountRepository;
import com.example.WebOnThiTracNghiem.service.ExamQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class QuizController {
    private final ExamQuestionService examQuestionService;

    private final AccountExamRepository accountExamRepository;

    private final ExamRepository examRepository;

    private final IAccountRepository accountRepository;

    List<Question> questions;
    @GetMapping("/exam/quiz_Exam/{id}")
    public String getQuizExam(@PathVariable("id") Long examId, Model model) {
        List<ExamQuestion> examQuestions = examQuestionService.getQuestionsByExamId(examId);
        questions = examQuestions.stream().map(ExamQuestion::getQuestion).collect(Collectors.toList());

        model.addAttribute("questions", examQuestions);
        model.addAttribute("examId", examId);
        return "Quiz/Exam";
    }
    @PostMapping("/exam/quiz_Exam/{id}")
    public String submitExam(@PathVariable("id") Long id, @RequestParam Map<String, String> allParams, Model model, Principal principal) {
        AccountExam accountExam = new AccountExam();

        Map<Long, String> correctAnswers = questions.stream()
                .collect(Collectors.toMap(Question::getIdQuestion, Question::getAnswer));

        int correctCount = 0;
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (entry.getKey().startsWith("question")) {
                Long questionId = Long.parseLong(entry.getKey().replace("question", ""));
                String userAnswer = entry.getValue().toString() ;

                if (correctAnswers.containsKey(questionId)) {
                    String correctAnswer = correctAnswers.get(questionId);
                    if (correctAnswer.equals(userAnswer)) {
                        correctCount++;
                    }
                }
            }
        }

        Exam exam = examRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid exam Id:" + id));
        accountExam.setExam(exam);

        Account account = accountRepository.findByUsername(principal.getName());
        accountExam.setAccount(account);

        float result= Math.round(((float)correctCount/exam.getQuantity())*10 * 2) / 2.0f;;
        accountExam.setResult(result);
        // Lưu AccountExam object vào database
        accountExamRepository.save(accountExam);

        // Trả về kết quả hoặc trang thông báo
        model.addAttribute("message", "Đã nộp bài thành công! Số câu trả lời đúng: " + correctCount+"/"+exam.getQuantity());
        model.addAttribute("point", "Điểm số của bạn: " + result);
        return "/Quiz/Result";
    }
}
