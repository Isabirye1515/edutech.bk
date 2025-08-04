package org.edutech.attendance.controller;

import org.edutech.attendance.AttendanceStream;
import org.edutech.attendance.dtos.AttendanceStreamDTO;
import org.edutech.attendance.services.AttendanceStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance-streams")
public class AttendanceStreamController {

    @Autowired
    private  AttendanceStreamService streamService;


    @GetMapping
    public List<AttendanceStreamDTO> getAll() {
        return streamService.getAll();
    }

    @GetMapping("/{id}")
    public AttendanceStreamDTO getById(@PathVariable int id) {
        return streamService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody AttendanceStream stream) {
        streamService.save(stream);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody AttendanceStream stream) {
        stream.setId(id);
        streamService.update(stream);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        streamService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        streamService.deleteAll();
    }
}
