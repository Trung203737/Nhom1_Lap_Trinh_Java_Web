package com.example.WebOnThiTracNghiem.service;

import com.example.WebOnThiTracNghiem.model.Exam;
import com.example.WebOnThiTracNghiem.model.ExamQuestion;
import com.example.WebOnThiTracNghiem.model.Question;
import com.example.WebOnThiTracNghiem.repository.ExamQuestionRepository;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
@Transactional
public class ExamQuestionService {
    @Autowired
    private ExamQuestionRepository examQuestionRepository;

    public List<ExamQuestion> getQuestionsByExamId(Long examId) {
        return examQuestionRepository.findByExamIdExam(examId);
    }
    public List<ExamQuestion> getExamQuestionByExamList(List<Exam> exams){
        return examQuestionRepository.findExamQuestionByExamIn(exams);
    }
    public void addQuestionExam(ExamQuestion examQuestion) {
        examQuestionRepository.save(examQuestion);
    }

    public void updateExamQuestion(@NotNull Long id, @NotNull Question updatedQuestion,  @NotNull Exam updatedExam) {
        ExamQuestion examQuestionToUpdate = examQuestionRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Exam with ID " + id + " does not exist."));

        // Update the fields of the existing subject entity
        examQuestionToUpdate.setQuestion(updatedQuestion);
        examQuestionToUpdate.setExam(updatedExam);

        // Save the updated subject entity
        examQuestionRepository.save(examQuestionToUpdate);
    }

    public List<ExamQuestion> getExamQuestionByQAE(Question deleteQuestion, Exam deleteExam) {
        return examQuestionRepository.findByQuestionAndExam(deleteQuestion, deleteExam);

    }

    public List<ExamQuestion> getExamQuestionByExam(Exam exam) {
        return examQuestionRepository.findExamQuestionByExam(exam);

    }

    public void deleteExamQuestionByQuestionAndExam(Question deleteQuestion, Exam deleteExam) {
        examQuestionRepository.deleteByQuestionAndExam(deleteQuestion, deleteExam);
    }
    public void deleteExamQuestionByQuestion(Optional<Question> question) {

        examQuestionRepository.deleteByQuestion(question);
    }

    public void deleteExamQuestionByExam(Exam exam) {

        examQuestionRepository.deleteByExam(exam);
    }
    public void deleteExamQuestionByExamQuestionList(List<ExamQuestion> questions) {
        examQuestionRepository.deleteAll(questions);
    }
    public List<ExamQuestion> getExamQuestionsByExamId(Long examId) {
        return examQuestionRepository.findByExam_IdExam(examId);
    }
    public String getExamNotesByQuestionId(Long questionId) {
        List<ExamQuestion> examQuestions = examQuestionRepository.findByQuestion_IdQuestion(questionId);

        // Assuming one Question is associated with one Exam in your application logic
        if (!examQuestions.isEmpty()) {
            Exam exam = examQuestions.get(0).getExam();
            return exam.getNote(); // Return the note from the associated Exam
        }

        return ""; // Return empty string or handle accordingly if no exam found
    }


}
