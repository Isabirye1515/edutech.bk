package org.edutech.dormitory.Controller;

import org.edutech.dormitory.services.BedLocationService;
import org.edutech.dormitory.valueholders.BedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bed-locations")
public class BedLocationController {

    @Autowired
    private BedLocationService bedLocationService;

    @PostMapping
    public ResponseEntity<String> addLocation(@RequestBody BedLocation location) {
        bedLocationService.addLocation(location);
        return ResponseEntity.ok("Location added");
    }

    @GetMapping
    public List<BedLocation> getAllLocations() {
        return bedLocationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BedLocation> getLocationById(@PathVariable int id) {
        BedLocation location = bedLocationService.getLocationById(id);
        return (location != null)
            ? ResponseEntity.ok(location)
            : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable int id, @RequestBody BedLocation updated) {
        BedLocation existing = bedLocationService.getLocationById(id);
        if (existing != null) {
            updated.setId(id);
            bedLocationService.updateLocation(updated);
            return ResponseEntity.ok("Location updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable int id) {
        BedLocation existing = bedLocationService.getLocationById(id);
        if (existing != null) {
            bedLocationService.deleteLocation(id);
            return ResponseEntity.ok("Location deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
