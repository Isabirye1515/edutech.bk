package org.edutech.classes.controller;

import java.util.List;
import org.edutech.classes.placeholders.Stream;
import org.edutech.classes.placeholders.StreamDTO;
import org.edutech.classes.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/streams")
public class StreamController {

  @Autowired private StreamService streamService;

  // ✅ Add Stream
  @PostMapping
  public ResponseEntity<String> addStream(@RequestBody Stream stream) {
    streamService.addStream(stream);
    return ResponseEntity.ok("Stream added successfully");
  }

  // ✅ Get all Streams (no students)
  @GetMapping
  public ResponseEntity<List<StreamDTO>> getAllStreams() {
    List<StreamDTO> streams = streamService.getAllStreamDTOs(false);
    return ResponseEntity.ok(streams);
  }

  // ✅ Get all Streams (with students)
  @GetMapping("/with-students")
  public ResponseEntity<List<StreamDTO>> getAllStreamsWithStudents() {
    List<StreamDTO> streams = streamService.getAllStreamDTOs(true);
    return ResponseEntity.ok(streams);
  }

  // ✅ Get Stream by streamNumber (basic)
  @GetMapping("/by-number/{streamNumber}")
  public ResponseEntity<Stream> getStreamByStreamNumber(@PathVariable String streamNumber) {
    Stream stream = streamService.getStreamByStreamNumber(streamNumber);
    if (stream == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(stream);
  }

  // ✅ Get single stream by ID (no students)
  @GetMapping("/{id}")
  public ResponseEntity<StreamDTO> getStreamById(@PathVariable int id) {
    StreamDTO dto = streamService.getStreamDTOById(id, false);
    if (dto == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(dto);
  }

  // ✅ Get stream by ID (with students)
  @GetMapping("/{id}/with-students")
  public ResponseEntity<StreamDTO> getStreamByIdWithStudents(@PathVariable int id) {
    StreamDTO dto = streamService.getStreamDTOById(id, true);
    if (dto == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(dto);
  }

  // ✅ Update Stream
  @PutMapping("/{id}")
  public ResponseEntity<String> updateStream(
      @PathVariable int id, @RequestBody Stream updatedStream) {
    Stream existingStream = streamService.getStreamById(id);
    if (existingStream == null) {
      return ResponseEntity.notFound().build();
    }

    // Only update relevant fields
    existingStream.setStreamName(updatedStream.getStreamName());
    existingStream.setDescription(updatedStream.getDescription());
    existingStream.setStreamNumber(updatedStream.getStreamNumber());
    existingStream.setClassRoom(updatedStream.getClassRoom());

    streamService.updateStream(existingStream);
    return ResponseEntity.ok("Stream updated successfully");
  }

  // ✅ Delete Stream
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStream(@PathVariable int id) {
    Stream stream = streamService.getStreamById(id);
    if (stream == null) {
      return ResponseEntity.notFound().build();
    }
    streamService.deleteStream(id);
    return ResponseEntity.ok("Stream deleted successfully");
  }
}
