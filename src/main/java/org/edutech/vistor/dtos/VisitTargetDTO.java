package org.edutech.vistor.dtos;

public class VisitTargetDTO {

  private int id;
  private String names;
  private String role;
  private String position;

  // Omit visitTypeDto or make it lightweight to avoid recursive nesting
  private int visitTypeId;

  public VisitTargetDTO() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getVisitTypeId() {
    return visitTypeId;
  }

  public void setVisitTypeId(int visitTypeId) {
    this.visitTypeId = visitTypeId;
  }
}
