package org.edutech.timetable.controller;

import org.edutech.timetable.WeekendTimeTable;
import org.edutech.timetable.Services.WeekendTimeTableService;
import org.edutech.timetable.dtos.WeekendTimeTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weekend-timetables")
public class WeekendTimeTableController {

    @Autowired
    private WeekendTimeTableService weekendTimeTableService;

    // Create a new weekend timetable
    @PostMapping
    public ResponseEntity<WeekendTimeTable> createWeekendTimeTable(@RequestBody WeekendTimeTable weekendTimeTable) {
        weekendTimeTableService.saveWeekendTimeTable(weekendTimeTable);
        return ResponseEntity.ok(weekendTimeTable);
    }

    // Get a weekend timetable by ID
    @GetMapping("/{id}")
    public ResponseEntity<WeekendTimeTable> getWeekendTimeTableById(@PathVariable int id) {
        WeekendTimeTable table = weekendTimeTableService.getWeekendTimeTableById(id);
        if (table == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(table);
    }
    

    // Get all weekend timetables
    @GetMapping
    public ResponseEntity<List<WeekendTimeTableDTO>> getAllWeekendTimeTables() {
        return ResponseEntity.ok(weekendTimeTableService.getAllWeekendTimeTables());
    }

    // Update a weekend timetable
    @PutMapping("/{id}")
    public ResponseEntity<WeekendTimeTable> updateWeekendTimeTable(
            @PathVariable int id,
            @RequestBody WeekendTimeTable updatedTable) {

        WeekendTimeTable existing = weekendTimeTableService.getWeekendTimeTableById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        updatedTable.setId(id); // Make sure the ID is retained
        weekendTimeTableService.updateWeekendTimeTable(updatedTable);
        return ResponseEntity.ok(updatedTable);
    }

    // Delete a weekend timetable
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeekendTimeTable(@PathVariable int id) {
        WeekendTimeTable existing = weekendTimeTableService.getWeekendTimeTableById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        weekendTimeTableService.deleteWeekendTimeTable(id);
        return ResponseEntity.noContent().build();
    }
}
