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
@Table(name = "exam_student")
public class ExamStudent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "student_name")
  private String studentName;

  @ManyToOne
  @JoinColumn(name = "exam_id")
  private Exam exam;

  @Column(name = "stream_name")
  private String streamName;

  @OneToMany(mappedBy = "examStudent", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Paper> papers;

  public ExamStudent() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStreamName() {
    return streamName;
  }

  public void setStreamName(String streamName) {
    this.streamName = streamName;
  }

  public Exam getExam() {
    return exam;
  }

  public void setExam(Exam exam) {
    this.exam = exam;
  }

  public Set<Paper> getPapers() {
    return papers;
  }

  public void setPapers(Set<Paper> papers) {
    this.papers = papers;
  }
}
