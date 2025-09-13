package org.edutech.classes.placeholders;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
public class ClassRooms {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "uuid", unique = true)
  private String uuid;

  @Column(name = "class_name", nullable = false)
  private String className;

  @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Stream> streams;

  public ClassRooms() {}

  // Getters and Setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public List<Stream> getStreams() {
    return streams;
  }

  public void setStreams(List<Stream> streams) {
    this.streams = streams;
  }

  @Override
  public String toString() {
    return "ClassRooms{"
        + "id="
        + id
        + ", uuid='"
        + uuid
        + '\''
        + ", className='"
        + className
        + '\''
        + '}';
  }
}
