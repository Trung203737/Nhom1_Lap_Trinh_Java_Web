package com.example.WebOnThiTracNghiem.repository;
import com.example.WebOnThiTracNghiem.model.AccountExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountExamRepository extends JpaRepository<AccountExam, Long>  {
}
