package org.edutech.classes.placeholders;

import java.util.List;

public class ClassRoomDTO {
  private int id;
  private String uuid;
  private String className;
  private List<StreamDTO> streams;

  // Getters and Setters

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

  public List<StreamDTO> getStreams() {
    return streams;
  }

  public void setStreams(List<StreamDTO> streams) {
    this.streams = streams;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
