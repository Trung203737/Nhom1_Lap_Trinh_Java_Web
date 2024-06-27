package com.example.WebOnThiTracNghiem.repository;
import com.example.WebOnThiTracNghiem.model.ExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Long> {
    List<ExamQuestion> findByExamIdExam(Long examId);
}
