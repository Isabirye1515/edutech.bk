package org.edutech.Student.controller;

import java.util.List;
import org.edutech.Student.services.ClubService;
import org.edutech.Student.valueholder.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

  @Autowired private ClubService clubService;

  @PostMapping
  public ResponseEntity<String> addClub(@RequestBody Club club) {
    clubService.addClub(club);
    return ResponseEntity.ok("Club added successfully");
  }

  @GetMapping
  public List<Club> getAllClubs() {
    return clubService.getAllClubs();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Club> getClubById(@PathVariable int id) {
    Club club = clubService.getClubById(id);
    return (club != null) ? ResponseEntity.ok(club) : ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateClub(@PathVariable int id, @RequestBody Club updated) {
    Club existing = clubService.getClubById(id);
    if (existing != null) {
      updated.setId(id);
      clubService.updateClub(updated);
      return ResponseEntity.ok("Club updated successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteClub(@PathVariable int id) {
    Club existing = clubService.getClubById(id);
    if (existing != null) {
      clubService.deleteClub(id);
      return ResponseEntity.ok("Club deleted successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
