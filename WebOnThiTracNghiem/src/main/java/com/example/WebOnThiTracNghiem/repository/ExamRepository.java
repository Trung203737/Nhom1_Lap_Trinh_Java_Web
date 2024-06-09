package com.example.WebOnThiTracNghiem.repository;
import com.example.WebOnThiTracNghiem.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
