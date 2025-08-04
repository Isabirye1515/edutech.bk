package org.edutech.Student.controller;

import org.edutech.Student.services.BordingStudentService;
import org.edutech.Student.valueholder.BordingStudent;
import org.edutech.Student.valueholder.dtos.BordingStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bording-students")
public class BordingStudentController {

    @Autowired
    private BordingStudentService service;

    @PostMapping
    public ResponseEntity<String> addBordingStudent(@RequestBody BordingStudent bordingStudent) {
        service.addBordingStudent(bordingStudent);
        return ResponseEntity.ok("Bording student registered successfully");
    }

    @GetMapping
    public List<BordingStudentDTO> getAllBordingStudents() {
        return service.getAllBordingStudentDtos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BordingStudentDTO> getBordingStudentById(@PathVariable int id) {
        BordingStudentDTO bordingStudent = service.getBordingStudentDtoById(id);
        return (bordingStudent != null)
            ? ResponseEntity.ok(bordingStudent)
            : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBordingStudent(@PathVariable int id, @RequestBody BordingStudent updated) {
        BordingStudent existing = service.getBordingStudentById(id);
        if (existing != null) {
            updated.setId(id);
            service.updateBordingStudent(updated);
            return ResponseEntity.ok("Updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBordingStudent(@PathVariable int id) {
        BordingStudent bordingStudent = service.getBordingStudentById(id);
        if (bordingStudent != null) {
            service.deleteBordingStudent(id);
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
