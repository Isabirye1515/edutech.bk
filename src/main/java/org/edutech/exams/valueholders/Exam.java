package org.edutech.exams.valueholders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "exam")
public class Exam {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "begin_on")
  private Date beginOn;

  @Column(name = "end_on")
  private Date endOn;

  @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<ExamStudent> examStudents;

  @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<SuperVisor> supervisors;

  public Exam() {}

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

  public Set<SuperVisor> getSupervisors() {
    return supervisors;
  }

  public void setSupervisors(Set<SuperVisor> supervisors) {
    this.supervisors = supervisors;
  }

  public Set<ExamStudent> getExamStudents() {
    return examStudents;
  }

  public void setExamStudents(Set<ExamStudent> examStudents) {
    this.examStudents = examStudents;
  }
}
