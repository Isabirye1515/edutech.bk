package org.edutech.exams.valueholders.dto;

import java.sql.Date;
import java.util.List;

public class ExamDTO {
  private int id;
  private String title;
  private Date beginOn;
  private Date endOn;
  private List<SuperVisorDTO> supervisors;
  private List<ExamStudentDTO> examStudents;

  public ExamDTO() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getBeginOn() {
    return beginOn;
  }

  public void setBeginOn(Date beginOn) {
    this.beginOn = beginOn;
  }

  public Date getEndOn() {
    return endOn;
  }

  public void setEndOn(Date endOn) {
    this.endOn = endOn;
  }

  public List<SuperVisorDTO> getSupervisors() {
    return supervisors;
  }

  public void setSupervisors(List<SuperVisorDTO> supervisors) {
    this.supervisors = supervisors;
  }

  public List<ExamStudentDTO> getExamStudents() {
    return examStudents;
  }

  public void setExamStudents(List<ExamStudentDTO> examStudents) {
    this.examStudents = examStudents;
  }
}
