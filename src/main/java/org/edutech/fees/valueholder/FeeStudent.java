package org.edutech.fees.valueholder;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "fees_student")
public class FeeStudent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "is_admitted")
  private boolean isAdmitted;

  @Column(name = "student_name")
  public String studentName;

  @Column(name = "student_id")
  private String studentId;

  @Column(name = "fees")
  private double fees;

  @Column(name = "period")
  private String period;

  @OneToMany(mappedBy = "feeStudent", cascade = CascadeType.ALL, orphanRemoval = false)
  private List<PaidAmount> paidAmount;

  public FeeStudent() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isAdmitted() {
    return isAdmitted;
  }

  public void setAdmitted(boolean isAdmitted) {
    this.isAdmitted = isAdmitted;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public double getFees() {
    return fees;
  }

  public void setFees(double fees) {
    this.fees = fees;
  }

  public List<PaidAmount> getPaidAmount() {
    return paidAmount;
  }

  public void setPaidAmount(List<PaidAmount> paidAmount) {
    this.paidAmount = paidAmount;
  }

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }
}
