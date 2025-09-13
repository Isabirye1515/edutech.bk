package org.edutech.dormitory.valueholders.dto;

public class BedDTO {
  private int id;
  private int column;
  private int row;
  private int level;
  private BedLocationDTO location;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public BedLocationDTO getLocation() {
    return location;
  }

  public void setLocation(BedLocationDTO location) {
    this.location = location;
  }
}
