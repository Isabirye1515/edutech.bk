package org.edutech.Student.controller;

import org.edutech.Student.services.StudentService;
import org.edutech.Student.valueholder.Student;
import org.edutech.Student.valueholder.dtos.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("Student added successfully");
    }

   @GetMapping
public List<StudentDTO> getAll() {
    return studentService.getAllStudentDTOS(); // ✅ uses mapped DTOs
}

@GetMapping("/{id}")
public StudentDTO getById(@PathVariable int id) {
    return studentService.getStudentDTOById(id); // ✅ uses mapped DTO
}


    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student existing = studentService.getStudentById(id);
        if (existing != null) {
            updatedStudent.setId(id);
            studentService.updateStudent(updatedStudent);
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
