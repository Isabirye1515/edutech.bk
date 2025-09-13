package org.edutech.Student.valueholder.dtos;

import org.edutech.dormitory.valueholders.dto.BedDTO;

public class BordingStudentDTO {
  private int id;
  private StudentDTO student;
  private BedDTO bed;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public StudentDTO getStudent() {
    return student;
  }

  public void setStudent(StudentDTO student) {
    this.student = student;
  }

  public BedDTO getBed() {
    return bed;
  }

  public void setBed(BedDTO bed) {
    this.bed = bed;
  }
}
