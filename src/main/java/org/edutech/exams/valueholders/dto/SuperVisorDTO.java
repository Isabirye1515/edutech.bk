package org.edutech.exams.valueholders.dto;

import java.sql.Date;
import java.sql.Time;

public class SuperVisorDTO {
  private int id;
  private String paperName;
  private String visorName;
  private Time startAt;
  private Time endAt;
  private Date day;
  private int examId;

  public SuperVisorDTO() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPaperName() {
    return paperName;
  }

  public void setPaperName(String paperName) {
    this.paperName = paperName;
  }

  public String getVisorName() {
    return visorName;
  }

  public void setVisorName(String visorName) {
    this.visorName = visorName;
  }

  public Time getStartAt() {
    return startAt;
  }

  public void setStartAt(Time startAt) {
    this.startAt = startAt;
  }

  public Time getEndAt() {
    return endAt;
  }

  public void setEndAt(Time endAt) {
    this.endAt = endAt;
  }

  public Date getDay() {
    return day;
  }

  public void setDay(Date day) {
    this.day = day;
  }

  public int getExamId() {
    return examId;
  }

  public void setExamId(int examId) {
    this.examId = examId;
  }
}
