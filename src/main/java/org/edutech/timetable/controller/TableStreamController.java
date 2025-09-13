package org.edutech.timetable.controller;

import java.util.List;
import org.edutech.timetable.Services.TableStreamService;
import org.edutech.timetable.TableStream;
import org.edutech.timetable.dtos.TableStreamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tableStreams")
public class TableStreamController {

  @Autowired private TableStreamService tableStreamService;

  // GET all TableStreams
  @GetMapping
  public ResponseEntity<List<TableStreamDTO>> getAll() {
    List<TableStreamDTO> streams = tableStreamService.getAll();
    return ResponseEntity.ok(streams);
  }

  // GET one TableStream by id
  @GetMapping("/{id}")
  public ResponseEntity<TableStreamDTO> getById(@PathVariable int id) {
    TableStreamDTO dto = tableStreamService.getById(id);
    if (dto == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(dto);
  }

  // POST create new TableStream
  @PostMapping
  public ResponseEntity<String> create(@RequestBody TableStream dto) {
    tableStreamService.addTableStream(dto);
    return ResponseEntity.ok("created");
  }

  // PUT update existing TableStream by id
  @PutMapping("/{id}")
  public ResponseEntity<String> update(@RequestBody TableStream dto) {
    tableStreamService.updateStreamTable(dto);

    return ResponseEntity.ok("updated");
  }

  // DELETE TableStream by id
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    tableStreamService.deleteStreamTable(id);
    return ResponseEntity.noContent().build();
  }
}
