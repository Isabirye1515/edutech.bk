package org.edutech.exams.controller;

import org.edutech.exams.service.RangeService;

import org.edutech.exams.valueholders.Ranges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ranges")
public class RangesController {

    @Autowired
    private RangeService rangesService;

    @GetMapping
    public ResponseEntity<List<Ranges>> getAllRanges() {
        return ResponseEntity.ok(rangesService.getAllRanges());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ranges> getRangeById(@PathVariable int id) {
        return ResponseEntity.ok(rangesService.getRangeById(id));
    }

    @PostMapping
    public ResponseEntity<String> createRange(@RequestBody Ranges ranges) {
        rangesService.createRange(ranges);
        return ResponseEntity.ok("Range created successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRange(@PathVariable int id, @RequestBody Ranges ranges) {
        if (id != ranges.getId()) {
            return ResponseEntity.badRequest().body("ID in path and body must match.");
        }
        rangesService.updateRange(ranges);
        return ResponseEntity.ok("Range updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRange(@PathVariable int id) {
        rangesService.deleteRange(id);
        return ResponseEntity.ok("Range deleted successfully.");
    }
}
