package org.edutech.vistor.controller;

import java.util.List;
import org.edutech.vistor.VisitTarget;
import org.edutech.vistor.dtos.VisitTargetDTO;
import org.edutech.vistor.service.VisitTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visit-targets")
public class VisitTargetController {

  @Autowired private VisitTargetService service;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody VisitTarget visitTarget) {
    service.save(visitTarget);
    return ResponseEntity.ok("Visit target saved.");
  }

  @GetMapping
  public List<VisitTargetDTO> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public VisitTargetDTO getOne(@PathVariable int id) {
    return service.getById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable int id, @RequestBody VisitTarget visitTarget) {
    visitTarget.setId(id);
    service.update(visitTarget);
    return ResponseEntity.ok("Visit target updated.");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable int id) {
    service.delete(id);
    return ResponseEntity.ok("Visit target deleted.");
  }
}
