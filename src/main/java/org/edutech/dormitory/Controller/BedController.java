package org.edutech.dormitory.Controller;

import org.edutech.dormitory.services.BedService;
import org.edutech.dormitory.valueholders.Bed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    @Autowired
    private BedService bedService;

    @PostMapping
    public ResponseEntity<String> addBed(@RequestBody Bed bed) {
        bedService.addBed(bed);
        return ResponseEntity.ok("Bed created successfully");
    }

    @GetMapping
    public List<Bed> getAllBeds() {
        return bedService.getAllBeds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bed> getBedById(@PathVariable int id) {
        Bed bed = bedService.getBedById(id);
        if (bed != null) {
            return ResponseEntity.ok(bed);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBed(@PathVariable int id, @RequestBody Bed updatedBed) {
        Bed existing = bedService.getBedById(id);
        if (existing != null) {
            updatedBed.setId(id);
            bedService.updateBed(updatedBed);
            return ResponseEntity.ok("Bed updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBed(@PathVariable int id) {
        Bed bed = bedService.getBedById(id);
        if (bed != null) {
            bedService.deleteBed(id);
            return ResponseEntity.ok("Bed deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
