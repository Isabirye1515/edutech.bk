package org.edutech.parent.controller;

import java.util.List;
import org.edutech.parent.services.ParentService;
import org.edutech.parent.valueholder.dto.ParentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

  @Autowired private ParentService parentService;

  // Create
  @PostMapping
  public ResponseEntity<ParentDTO> createParent(@RequestBody ParentDTO dto) {
    parentService.saveParent(dto);
    return ResponseEntity.ok(dto);
  }

  // Read (by ID)
  @GetMapping("/{id}")
  public ResponseEntity<ParentDTO> getParent(@PathVariable int id) {
    ParentDTO dto = parentService.getParentById(id);
    if (dto == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(dto);
  }

  // Read (all)
  @Transactional
  @GetMapping
  public ResponseEntity<List<ParentDTO>> getAllParents() {
    return ResponseEntity.ok(parentService.getAllParents());
  }

  // Update
  @PutMapping("/{id}")
  public ResponseEntity<ParentDTO> updateParent(@PathVariable int id, @RequestBody ParentDTO dto) {
    if (parentService.getParentById(id) == null) {
      return ResponseEntity.notFound().build();
    }
    dto.setId(id);
    parentService.updateParent(dto);
    return ResponseEntity.ok(dto);
  }

  // Delete
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteParent(@PathVariable int id) {
    if (parentService.getParentById(id) == null) {
      return ResponseEntity.notFound().build();
    }
    parentService.deleteParent(id);
    return ResponseEntity.noContent().build();
  }
}
