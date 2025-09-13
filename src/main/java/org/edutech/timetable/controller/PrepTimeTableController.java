package org.edutech.timetable.controller;

import java.util.List;
import org.edutech.timetable.PrepTimeTable;
import org.edutech.timetable.Services.PrepTimeTableService;
import org.edutech.timetable.dtos.PrepTimeTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prep-timetables")
public class PrepTimeTableController {

  @Autowired private PrepTimeTableService prepTimeTableService;

  // Create a new PrepTimeTable
  @PostMapping
  public ResponseEntity<PrepTimeTable> createPrepTimeTable(
      @RequestBody PrepTimeTable prepTimeTable) {
    prepTimeTableService.savePrepTimeTable(prepTimeTable);
    return ResponseEntity.ok(prepTimeTable);
  }

  // Get a PrepTimeTable by ID
  @GetMapping("/{id}")
  public ResponseEntity<PrepTimeTable> getPrepTimeTableById(@PathVariable int id) {
    PrepTimeTable table = prepTimeTableService.getPrepTimeTableById(id);
    if (table == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(table);
  }

  // Get all PrepTimeTables
  @GetMapping
  public ResponseEntity<List<PrepTimeTableDTO>> getAllPrepTimeTables() {
    return ResponseEntity.ok(prepTimeTableService.getAllPrepTimeTables());
  }

  // Update a PrepTimeTable
  @PutMapping("/{id}")
  public ResponseEntity<PrepTimeTable> updatePrepTimeTable(
      @PathVariable int id, @RequestBody PrepTimeTable updatedTable) {

    PrepTimeTable existing = prepTimeTableService.getPrepTimeTableById(id);
    if (existing == null) {
      return ResponseEntity.notFound().build();
    }

    updatedTable.setId(id); // Ensure the correct ID is used
    prepTimeTableService.updatePrepTimeTable(updatedTable);
    return ResponseEntity.ok(updatedTable);
  }

  // Delete a PrepTimeTable
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePrepTimeTable(@PathVariable int id) {
    PrepTimeTable existing = prepTimeTableService.getPrepTimeTableById(id);
    if (existing == null) {
      return ResponseEntity.notFound().build();
    }
    prepTimeTableService.deletePrepTimeTable(id);
    return ResponseEntity.noContent().build();
  }

  // Get PrepTimeTable by Day
  @GetMapping("/day/{day}")
  public ResponseEntity<PrepTimeTable> getPrepTimeTableByDay(@PathVariable String day) {
    PrepTimeTable table = prepTimeTableService.getPrepTimeTableByDay(day);
    if (table == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(table);
  }
}
