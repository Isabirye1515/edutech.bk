package org.edutech.exams.valueholders;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "marks")
public class Marks {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "paper_name")
  private String paperName;

  @Column(name = "marked_by")
  private String markedBy;

  @Column(name = "paper_code")
  private String paperCode;

  @Column(name = "mark")
  private double mark;

  @Column(name = "grade")
  private String grade;

  @Column(name = "remark")
  private String remark;

  @ManyToOne
  @JoinColumn(name = "paper_id")
  private Paper paper;

  public Marks() {}

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

  public Paper getPaper() {
    return paper;
  }

  public void setPaper(Paper paper) {
    this.paper = paper;
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
