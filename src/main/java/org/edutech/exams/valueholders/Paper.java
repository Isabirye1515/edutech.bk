package org.edutech.exams.valueholders;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "paper")
public class Paper {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "abrev")
  private String abrev;

  @Column(name = "paper_name")
  private String paperName;

  @ManyToOne
  @JoinColumn(name = "exam_student_id")
  private ExamStudent examStudent;

  @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Marks> marks;

  public Paper() {}

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

  public ExamStudent getExamStudent() {
    return examStudent;
  }

  public void setExamStudent(ExamStudent examStudent) {
    this.examStudent = examStudent;
  }

  public Set<Marks> getMarks() {
    return marks;
  }

  public void setMarks(Set<Marks> marks) {
    this.marks = marks;
  }

  public String getAbrev() {
    return abrev;
  }

  public void setAbrev(String abrev) {
    this.abrev = abrev;
  }
}
