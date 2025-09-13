package org.edutech.Student.valueholder;

import jakarta.persistence.*;
import org.edutech.dormitory.valueholders.Bed;

@Entity
@Table(name = "bording_student")
public class BordingStudent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;

  @OneToOne
  @JoinColumn(name = "bed_id", nullable = false)
  private Bed bed;

  public BordingStudent() {}

  // Getters and Setters

  public int getId() {
    return id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Bed getBed() {
    return bed;
  }

  public void setBed(Bed bed) {
    this.bed = bed;
  }

  public void setId(int id) {
    this.id = id;
  }
}
