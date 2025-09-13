package org.edutech.subject.controller;

import java.util.List;
import org.edutech.subject.service.SubjectService;
import org.edutech.subject.valueholder.Subject;
import org.edutech.subject.valueholder.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
  @Autowired private SubjectService subjectService;

  @GetMapping("/")
  public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
    List<SubjectDTO> subjects = subjectService.getAllSubjects();
    return ResponseEntity.ok(subjects);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable int id) {
    SubjectDTO subject = subjectService.getSubjectDTOById(id);
    if (subject == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(subject);
  }

  @PostMapping("/")
  public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
    subjectService.saveSubject(subject);
    return ResponseEntity.ok(subject);
  }

  @PostMapping("/{id}")
  public ResponseEntity<Subject> updateSubject(
      @PathVariable int id, @RequestBody Subject updatedSubject) {
    Subject existingSubject = subjectService.getSubjectById(id);
    if (existingSubject == null) {
      return ResponseEntity.notFound().build();
    }
    updatedSubject.setId(id); // Ensure the ID is retained
    subjectService.updateSubject(updatedSubject);
    return ResponseEntity.ok(updatedSubject);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSubject(@PathVariable int id) {
    Subject existingSubject = subjectService.getSubjectById(id);
    if (existingSubject == null) {
      return ResponseEntity.notFound().build();
    }
    subjectService.deleteSubject(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/")
  public ResponseEntity<Void> deleteAllSubjects() {
    subjectService.deleteAllSubjects();
    return ResponseEntity.noContent().build();
  }
}
