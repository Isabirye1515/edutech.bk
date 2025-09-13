package org.edutech.attendance.dtos;

import java.sql.Date;

public class PresentDTO {

  private int id;
  private Date day;
  private boolean isPresent;
  private int attandenceStudentId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDay() {
    return day;
  }

  public void setDay(Date day) {
    this.day = day;
  }

  public boolean isPresent() {
    return isPresent;
  }

  public void setPresent(boolean isPresent) {
    this.isPresent = isPresent;
  }

  public int getAttandenceStudentId() {
    return attandenceStudentId;
  }

  public void setAttandenceStudentId(int attandenceStudentId) {
    this.attandenceStudentId = attandenceStudentId;
  }
}
