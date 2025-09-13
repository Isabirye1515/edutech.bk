package org.edutech.dormitory.valueholders.dto;

public class BedLocationDTO {
  private int id;
  private String wing;
  private String room;
  private String description;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getWing() {
    return wing;
  }

  public void setWing(String wing) {
    this.wing = wing;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
