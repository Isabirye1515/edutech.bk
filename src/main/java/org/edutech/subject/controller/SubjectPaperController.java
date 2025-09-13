package org.edutech.subject.controller;

import java.util.List;
import org.edutech.subject.service.SubjectPaperService;
import org.edutech.subject.valueholder.SubjectPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject-papers")
public class SubjectPaperController {

  @Autowired private SubjectPaperService subjectPaperService;

  @PostMapping
  public ResponseEntity<String> addSubjectPaper(@RequestBody SubjectPaper subjectPaper) {
    subjectPaperService.addSubjectPaper(subjectPaper);
    return ResponseEntity.ok("SubjectPaper added successfully.");
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubjectPaper> getSubjectPaperById(@PathVariable int id) {
    SubjectPaper paper = subjectPaperService.getSubjectPaperById(id);
    if (paper == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(paper);
  }

  @GetMapping
  public List<SubjectPaper> getAllSubjectPapers() {
    return subjectPaperService.getAllSubjectPapers();
  }

  @PutMapping
  public ResponseEntity<String> updateSubjectPaper(@RequestBody SubjectPaper subjectPaper) {
    subjectPaperService.updateSubjectPaper(subjectPaper);
    return ResponseEntity.ok("SubjectPaper updated successfully.");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSubjectPaperById(@PathVariable int id) {
    subjectPaperService.deleteSubjectPaperById(id);
    return ResponseEntity.ok("SubjectPaper deleted successfully.");
  }

  @DeleteMapping
  public ResponseEntity<String> deleteAllSubjectPapers() {
    subjectPaperService.deleteAllSubjectPapers();
    return ResponseEntity.ok("All SubjectPapers deleted.");
  }
}
