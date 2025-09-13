package org.edutech.exams.controller;

import java.util.List;
import org.edutech.exams.service.SuperVisorService;
import org.edutech.exams.valueholders.SuperVisor;
import org.edutech.exams.valueholders.dto.SuperVisorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supervisors")
public class SuperVisorController {

  @Autowired private SuperVisorService superVisorService;

  @PostMapping
  public ResponseEntity<String> add(@RequestBody SuperVisor supervisor) {
    superVisorService.addSuperVisor(supervisor);
    return ResponseEntity.ok("Supervisor added");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@RequestBody SuperVisor supervisor) {
    superVisorService.updateSuperVisor(supervisor);
    return ResponseEntity.ok("Supervisor updated");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable int id) {
    superVisorService.deleteSuperVisor(id);
    return ResponseEntity.ok("Supervisor deleted");
  }

  @GetMapping("/{id}")
  public ResponseEntity<SuperVisorDTO> getById(@PathVariable int id) {
    return ResponseEntity.ok(superVisorService.getSuperVisorById(id));
  }

  @GetMapping
  public ResponseEntity<List<SuperVisorDTO>> getAll() {
    return ResponseEntity.ok(superVisorService.getAllSuperVisors());
  }
}
