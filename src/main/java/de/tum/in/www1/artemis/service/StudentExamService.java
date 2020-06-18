package de.tum.in.www1.artemis.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import de.tum.in.www1.artemis.domain.exam.Exam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.tum.in.www1.artemis.domain.exam.StudentExam;
import de.tum.in.www1.artemis.repository.StudentExamRepository;
import de.tum.in.www1.artemis.web.rest.errors.EntityNotFoundException;

/**
 * Service Implementation for managing StudentExam.
 */
@Service
public class StudentExamService {

    private final Logger log = LoggerFactory.getLogger(StudentExamService.class);

    private final StudentExamRepository studentExamRepository;

    private final ExamAccessService examAccessService;

    public StudentExamService(StudentExamRepository studentExamRepository, ExamAccessService examAccessService) {
        this.studentExamRepository = studentExamRepository;
        this.examAccessService = examAccessService;
    }

    /**
     * Get one student exam by id.
     *
     * @param studentExamId the id of the student exam
     * @return the entity
     */
    @NotNull
    public StudentExam findOne(Long studentExamId) {
        log.debug("Request to get student exam : {}", studentExamId);
        return studentExamRepository.findById(studentExamId).orElseThrow(() -> new EntityNotFoundException("Student exam with id \"" + studentExamId + "\" does not exist"));
    }

    /**
     * Get all student exams for the given exam.
     *
     * @param examId the id of the exam
     * @return the list of all student exams
     */
    public List<StudentExam> findAllByExamId(Long examId) {
        log.debug("Request to get all student exams for Exam : {}", examId);
        return studentExamRepository.findByExamId(examId);
    }

    /**
     * Get student exam for the given exam and user.
     *
     * @param examId the id of the exam
     * @param userId the id of the user
     * @return the list of all student exams
     */
    public StudentExam findOneByExamIdAndUserId(Long examId, Long userId) {
        log.debug("Request to get student exams for Exam : {} and User : {}", examId, userId);
        return studentExamRepository.findByExamIdAndUserId(examId, userId);
    }

    /**
     * Delete a student exam by the Id
     *
     * @param studentExamId the id of the student exam to be deleted
     */
    public void deleteStudentExam(Long studentExamId) {
        log.debug("Request to delete the student exam with Id : {}", studentExamId);
        studentExamRepository.deleteById(studentExamId);
    }
}
