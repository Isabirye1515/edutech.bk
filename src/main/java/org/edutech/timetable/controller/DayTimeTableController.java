package org.edutech.timetable.controller;

import org.edutech.timetable.DayTimeTable;
import org.edutech.timetable.Services.DayTimeTableService;
import org.edutech.timetable.dtos.DayTimeTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/day-timetables")
public class DayTimeTableController {

    @Autowired
    private DayTimeTableService dayTimeTableService;

    // Create a new DayTimeTable
    @PostMapping
    public ResponseEntity<DayTimeTable> createDayTimeTable(@RequestBody DayTimeTable dayTimeTable) {
        dayTimeTableService.saveDayTime(dayTimeTable);
        return ResponseEntity.ok(dayTimeTable);
    }

    // Get a DayTimeTable by ID
    @GetMapping("/{id}")
    public ResponseEntity<DayTimeTableDTO> getDayTimeTable(@PathVariable int id) {
        DayTimeTableDTO table = dayTimeTableService.getDayTimeDTOById(id);
        if (table == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(table);
    }

    // Get all DayTimeTables
    @GetMapping
    public ResponseEntity<List<DayTimeTableDTO>> getAllDayTimeTables() {
        List<DayTimeTableDTO> tables = dayTimeTableService.getAllDayTimeDTOs();
        return ResponseEntity.ok(tables);
    }

    // Update a DayTimeTable
    @PutMapping("/{id}")
    public ResponseEntity<DayTimeTable> updateDayTimeTable(@PathVariable int id, @RequestBody DayTimeTable updated) {
        DayTimeTable existing = dayTimeTableService.getDayTimeById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        updated.setId(id); // Ensure the ID is preserved
        dayTimeTableService.updateDayTime(updated);
        return ResponseEntity.ok(updated);
    }

    // Delete a DayTimeTable
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDayTimeTable(@PathVariable int id) {
        DayTimeTable existing = dayTimeTableService.getDayTimeById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        dayTimeTableService.deleteDayTime(id);
        return ResponseEntity.noContent().build();
    }
}
