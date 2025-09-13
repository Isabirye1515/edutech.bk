package org.edutech.vistor.controller;

import java.util.List;
import org.edutech.vistor.Vistor;
import org.edutech.vistor.dtos.VisitorDTO;
import org.edutech.vistor.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

  @Autowired private VisitorService service;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody Vistor visitor) {
    service.save(visitor);
    return ResponseEntity.ok("Visitor saved.");
  }

  @GetMapping
  public List<VisitorDTO> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public VisitorDTO getOne(@PathVariable int id) {
    return service.getById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable int id, @RequestBody Vistor visitor) {
    visitor.setId(id);
    service.update(visitor);
    return ResponseEntity.ok("Visitor updated.");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable int id) {
    service.delete(id);
    return ResponseEntity.ok("Visitor deleted.");
  }
}
