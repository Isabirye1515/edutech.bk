package org.edutech.vistor.controller;

import java.util.List;
import org.edutech.vistor.VisitType;
import org.edutech.vistor.dtos.VisitTypeDTO;
import org.edutech.vistor.service.VisitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visit-types")
public class VisitTypeController {

  @Autowired private VisitTypeService service;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody VisitType visitType) {
    service.save(visitType);
    return ResponseEntity.ok("Visit type saved.");
  }

  @GetMapping
  public ResponseEntity<List<VisitTypeDTO>> getAll() {
    List<VisitTypeDTO> types = service.getAll();
    return ResponseEntity.ok(types);
  }

  @GetMapping("/{id}")
  public VisitTypeDTO getOne(@PathVariable int id) {
    return service.getById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable int id, @RequestBody VisitType visitType) {
    visitType.setId(id);
    service.update(visitType);
    return ResponseEntity.ok("Visit type updated.");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable int id) {
    service.delete(id);
    return ResponseEntity.ok("Visit type deleted.");
  }
}
