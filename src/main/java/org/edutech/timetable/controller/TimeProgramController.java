package org.edutech.timetable.controller;

import org.edutech.timetable.TimeProgram;
import org.edutech.timetable.Services.TimeProgramService;
import org.edutech.timetable.dtos.TimeProgramDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-programs")
public class TimeProgramController {

    @Autowired
    private TimeProgramService timeProgramService;

    // Create a new time program
    @PostMapping
    public ResponseEntity<TimeProgram> createTimeProgram(@RequestBody TimeProgram timeProgram) {
        timeProgramService.saveTimeProgram(timeProgram);
        return ResponseEntity.ok(timeProgram);
    }

    // Get time program by ID
    @GetMapping("/{id}")
    public ResponseEntity<TimeProgramDTO> getTimeProgram(@PathVariable int id) {
        TimeProgramDTO program = timeProgramService.getTimeProgramDTO(id);
        if (program == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(program);
    }

    // Get all time programs
    @GetMapping
    public ResponseEntity<List<TimeProgramDTO>> getAllTimePrograms() {
        List<TimeProgramDTO> programs = timeProgramService.getAllDTO();
        return ResponseEntity.ok(programs);
    }

    // Update a time program
    @PutMapping("/{id}")
    public ResponseEntity<TimeProgram> updateTimeProgram(@PathVariable int id, @RequestBody TimeProgram updatedProgram) {
        TimeProgram existing = timeProgramService.getTimeProgramById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        updatedProgram.setId(id);
        timeProgramService.updateTimeProgram(updatedProgram);
        return ResponseEntity.ok(updatedProgram);
    }

    // Delete a time program
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeProgram(@PathVariable int id) {
        TimeProgram existing = timeProgramService.getTimeProgramById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        timeProgramService.deleteTimeProgram(id);
        return ResponseEntity.noContent().build();
    }
}
