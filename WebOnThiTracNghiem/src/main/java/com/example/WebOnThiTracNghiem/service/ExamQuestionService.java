package com.example.WebOnThiTracNghiem.service;

import com.example.WebOnThiTracNghiem.model.ExamQuestion;
import com.example.WebOnThiTracNghiem.model.Question;
import com.example.WebOnThiTracNghiem.repository.ExamQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
@Transactional
public class ExamQuestionService {
    @Autowired
    private ExamQuestionRepository examQuestionRepository;

    public List<Question> getQuestionsByExamId(Long examId) {
        List<ExamQuestion> examQuestions = examQuestionRepository.findByExamIdExam(examId);
        return examQuestions.stream()
                .map(ExamQuestion::getQuestion)
                .collect(Collectors.toList());
    }
}
