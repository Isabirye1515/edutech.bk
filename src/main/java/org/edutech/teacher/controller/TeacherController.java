package org.edutech.teacher.controller;

import java.util.List;
import org.edutech.teacher.service.TeacherService;
import org.edutech.teacher.valueholders.Teacher;
import org.edutech.teacher.valueholders.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

  @Autowired private TeacherService teacherService;

  @PostMapping
  public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
    teacherService.saveTeacher(teacher);
    return ResponseEntity.ok(teacher);
  }

  @GetMapping
  public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
    List<TeacherDTO> teachers = teacherService.getAllTeachers();
    return ResponseEntity.ok(teachers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TeacherDTO> getTeacherDTOById(@PathVariable int id) {
    TeacherDTO teacher = teacherService.getTeacherDTOById(id);
    if (teacher == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(teacher);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Teacher> updateTeacher(
      @PathVariable int id, @RequestBody Teacher updatedTeacher) {
    Teacher existingTeacher = teacherService.getTeacherById(id);
    if (existingTeacher == null) {
      return ResponseEntity.notFound().build();
    }
    updatedTeacher.setId(id);
    teacherService.updateTeacher(updatedTeacher);
    return ResponseEntity.ok(updatedTeacher);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
    Teacher existingTeacher = teacherService.getTeacherById(id);
    if (existingTeacher == null) {
      return ResponseEntity.notFound().build();
    }
    teacherService.deleteTeacher(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/all")
  public ResponseEntity<Void> deleteAllTeachers() {
    teacherService.deleteAllTeachers();
    return ResponseEntity.noContent().build();
  }
}
