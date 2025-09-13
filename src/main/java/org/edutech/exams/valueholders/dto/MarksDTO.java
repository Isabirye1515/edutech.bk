package org.edutech.exams.valueholders.dto;

public class MarksDTO {
  private int id;
  private String paperName;
  private String markedBy;
  private String paperCode;
  private double mark;
  private String grade;
  private String remark;

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

  public double getMark() {
    return mark;
  }

  public void setMark(double mark) {
    this.mark = mark;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getMarkedBy() {
    return markedBy;
  }

  public void setMarkedBy(String markedBy) {
    this.markedBy = markedBy;
  }

  public String getPaperCode() {
    return paperCode;
  }

  public void setPaperCode(String paperCode) {
    this.paperCode = paperCode;
  }
}
