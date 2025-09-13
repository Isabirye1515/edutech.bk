package org.edutech.dormitory.valueholders;

import jakarta.persistence.*;

@Entity
@Table(name = "bed")
public class Bed {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "bed_column") // renamed to avoid SQL reserved word conflict
  private int column;

  @Column(name = "row")
  private int row;

  @Column(name = "level")
  private int level;

  @OneToOne
  @JoinColumn(name = "location_id", nullable = false)
  private BedLocation location;

  public Bed() {}

  // Getters and setters

  public int getId() {
    return id;
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

  public BedLocation getLocation() {
    return location;
  }

  public void setLocation(BedLocation location) {
    this.location = location;
  }

  public void setId(int id) {
    this.id = id;
  }
}
