package org.edutech.classes.placeholders;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "stream")
public class Stream {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "stream_name", nullable = false, unique = true)
  private String streamName;

  @Column(name = "stream_description")
  private String description;

  @Column(name = "stream_number", unique = true)
  private String streamNumber;

  @ManyToOne
  @JoinColumn(name = "class_id")
  @JsonBackReference
  private ClassRooms classRoom;

  // Default constructor
  public Stream() {}

  // Getters and Setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStreamName() {
    return streamName;
  }

  public void setStreamName(String streamName) {
    this.streamName = streamName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStreamNumber() {
    return streamNumber;
  }

  public void setStreamNumber(String streamNumber) {
    this.streamNumber = streamNumber;
  }

  public ClassRooms getClassRoom() {
    return classRoom;
  }

  public void setClassRoom(ClassRooms classRoom) {
    this.classRoom = classRoom;
  }

  // Optional: for logging/debugging
  @Override
  public String toString() {
    return "Stream{"
        + "id="
        + id
        + ", streamName='"
        + streamName
        + '\''
        + ", description='"
        + description
        + '\''
        + ", streamNumber='"
        + streamNumber
        + '\''
        + '}';
  }
}
