package com.example.WebOnThiTracNghiem.repository;
import com.example.WebOnThiTracNghiem.model.ExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Long> {
}
