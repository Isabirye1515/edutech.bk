package org.edutech.exams.controller;

import org.edutech.exams.valueholders.Exam;
import org.edutech.exams.valueholders.dto.ExamDTO;
import org.edutech.exams.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Exam exam) {
        examService.saveExam(exam);
        return ResponseEntity.ok("Exam added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Exam exam) {
        examService.updateExam(exam);
        return ResponseEntity.ok("Exam updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        examService.deleteExam(id);
        return ResponseEntity.ok("Exam deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(examService.getExamById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExamDTO>> getAll() {
        return ResponseEntity.ok(examService.getAllExams());
    }
}
