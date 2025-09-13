package org.edutech.exams.controller;

import java.util.List;
import org.edutech.exams.service.PaperService;
import org.edutech.exams.valueholders.Paper;
import org.edutech.exams.valueholders.dto.PaperRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/papers")
public class PaperController {

  @Autowired private PaperService paperService;

  // GET all papers - returns list of DTOs
  @GetMapping
  public ResponseEntity<List<PaperRequestDTO>> getAllPapers() {
    return ResponseEntity.ok(paperService.getAllPapers());
  }

  // GET paper by id - returns DTO
  @GetMapping("/{id}")
  public ResponseEntity<PaperRequestDTO> getPaperById(@PathVariable int id) {
    return ResponseEntity.ok(paperService.getPaperById(id));
  }

  // POST create paper - expects full entity (JSON matching Paper entity)
  @PostMapping
  public ResponseEntity<String> createPaper(@RequestBody Paper paper) {
    paperService.createPaper(paper);
    return ResponseEntity.ok("Paper created successfully.");
  }

  // PUT update paper - expects full entity (JSON matching Paper entity)
  @PutMapping("/{id}")
  public ResponseEntity<String> updatePaper(@PathVariable int id, @RequestBody Paper paper) {
    if (paper.getId() != id) {
      return ResponseEntity.badRequest().body("ID in path and body must match.");
    }
    paperService.updatePaper(paper);
    return ResponseEntity.ok("Paper updated successfully.");
  }

  // DELETE paper by id
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePaper(@PathVariable int id) {
    paperService.deletePaper(id);
    return ResponseEntity.ok("Paper deleted successfully.");
  }
}
