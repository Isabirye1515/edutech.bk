package org.edutech.classes.controller;

import java.util.List;
import org.edutech.classes.placeholders.ClassRoomDTO;
import org.edutech.classes.placeholders.ClassRooms;
import org.edutech.classes.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classrooms")
public class ClassRoomController {

  @Autowired private ClassRoomService classRoomService;

  // Add a new classroom
  @PostMapping
  public ResponseEntity<String> addClassRoom(@RequestBody ClassRooms classRoom) {
    classRoomService.addClassRoom(classRoom);
    return ResponseEntity.ok("ClassRoom added successfully.");
  }

  // Get all classrooms as DTOs
  @GetMapping("/")
  public ResponseEntity<List<ClassRoomDTO>> getAllClassRoomDTOs() {
    List<ClassRoomDTO> list = classRoomService.getAllClassRoomDTOs();
    return ResponseEntity.ok(list);
  }

  // Get classroom by name (raw JPA)
  @GetMapping("/{className}")
  public ResponseEntity<ClassRooms> getClassRoomByName(@PathVariable String className) {
    ClassRooms classRoom = classRoomService.getClassRoomByName(className);
    if (classRoom == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(classRoom);
  }

  // Get classroom by name as DTO
  @GetMapping("/{className}/dto")
  public ResponseEntity<ClassRoomDTO> getClassWithStreams(@PathVariable String className) {
    ClassRoomDTO dto = classRoomService.getClassWithStreams(className);
    if (dto == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(dto);
  }

  // Update classroom
  @PutMapping("/{className}")
  public ResponseEntity<String> updateClassRoom(
      @PathVariable String className, @RequestBody ClassRooms updated) {
    ClassRooms existing = classRoomService.getClassRoomByName(className);
    if (existing == null) {
      return ResponseEntity.notFound().build();
    }

    existing.setClassName(updated.getClassName());
    existing.setUuid(updated.getUuid());
    existing.setStreams(updated.getStreams());

    classRoomService.updateClassRoom(existing);
    return ResponseEntity.ok("ClassRoom updated successfully.");
  }

  // Delete classroom
  @DeleteMapping("/{className}")
  public ResponseEntity<String> deleteClassRoom(@PathVariable String className) {
    ClassRooms classRoom = classRoomService.getClassRoomByName(className);
    if (classRoom == null) {
      return ResponseEntity.notFound().build();
    }

    classRoomService.deleteClassRoom(className);
    return ResponseEntity.ok("ClassRoom deleted successfully.");
  }
}
