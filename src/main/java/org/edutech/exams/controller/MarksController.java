package org.edutech.exams.controller;

import java.util.List;
import org.edutech.exams.service.MarksService;
import org.edutech.exams.valueholders.Marks;
import org.edutech.exams.valueholders.dto.MarksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

  @Autowired private MarksService marksService;

  @GetMapping
  public ResponseEntity<List<MarksDTO>> getAllMarks() {
    return ResponseEntity.ok(marksService.getAllMarks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<MarksDTO> getMarksById(@PathVariable int id) {
    return ResponseEntity.ok(marksService.getMarksById(id));
  }

  @PostMapping
  public ResponseEntity<String> createMarks(@RequestBody Marks marks) {
    marksService.createMarks(marks);
    return ResponseEntity.ok("Marks created");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateMarks(@PathVariable int id, @RequestBody Marks marks) {
    marks.setId(id);
    marksService.updateMarks(marks);
    return ResponseEntity.ok("Marks updated");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteMarks(@PathVariable int id) {
    marksService.deleteMarks(id);
    return ResponseEntity.ok("Marks deleted");
  }

  @GetMapping("/bystudent/{examStudentId}")
  public ResponseEntity<List<Marks>> getMarksByExamStudentId(@PathVariable int examStudentId) {
    return ResponseEntity.ok(marksService.getMarksByExamStudentId(examStudentId));
  }
}
