package com.example.WebOnThiTracNghiem.service;

import com.example.WebOnThiTracNghiem.model.Exam;
import com.example.WebOnThiTracNghiem.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ExamService {
    private final ExamRepository examRepository;

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam loadExamById(Long id) {
        return examRepository.findByIdExam(id);
    }
}
