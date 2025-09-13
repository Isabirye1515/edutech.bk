package org.edutech.attendance.controller;

import java.util.List;
import org.edutech.attendance.AttendanceStudent;
import org.edutech.attendance.dtos.AttendanceStudentDTO;
import org.edutech.attendance.services.AttendanceStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance-students")
public class AttendanceStudentController {

  @Autowired private AttendanceStudentService studentService;

  @GetMapping
  public List<AttendanceStudentDTO> getAll() {
    return studentService.getAll();
  }

  @GetMapping("/{id}")
  public AttendanceStudentDTO getById(@PathVariable int id) {
    return studentService.getById(id);
  }

  @PostMapping
  public void create(@RequestBody AttendanceStudent student) {
    studentService.save(student);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable int id, @RequestBody AttendanceStudent student) {
    student.setId(id);
    studentService.update(student);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable int id) {
    studentService.deleteById(id);
  }

  @DeleteMapping
  public void deleteAll() {
    studentService.deleteAll();
  }
}
