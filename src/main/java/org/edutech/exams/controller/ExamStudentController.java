package org.edutech.exams.controller;

import org.edutech.exams.service.ExamStudentService;
import org.edutech.exams.valueholders.ExamStudent;
import org.edutech.exams.valueholders.dto.ExamStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examStudents")
public class ExamStudentController {

    @Autowired
    private ExamStudentService examStudentService;

    @GetMapping
    public ResponseEntity<List<ExamStudentDTO>> getAll() {
        return ResponseEntity.ok(examStudentService.getAllExamStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamStudentDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(examStudentService.getExamStudentById(id));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ExamStudent examStudent) {
        examStudentService.createExamStudent(examStudent);
        return ResponseEntity.ok("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ExamStudent examStudent) {
        examStudent.setId(id);
        examStudentService.updateExamStudent(examStudent);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        examStudentService.deleteExamStudent(id);
        return ResponseEntity.ok("Deleted");
    }
}
