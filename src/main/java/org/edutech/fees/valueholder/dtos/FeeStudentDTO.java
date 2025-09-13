package org.edutech.fees.valueholder.dtos;

import java.util.List;

public class FeeStudentDTO {
  private int id;
  private boolean isAdmitted;
  private String studentName;
  private String studentId;
  private double fees;
  private String period;
  private List<PaidAmountDTO> paidAmounts;

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isAdmitted() {
    return isAdmitted;
  }

  public void setAdmitted(boolean admitted) {
    isAdmitted = admitted;
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

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public List<PaidAmountDTO> getPaidAmounts() {
    return paidAmounts;
  }

  public void setPaidAmounts(List<PaidAmountDTO> paidAmounts) {
    this.paidAmounts = paidAmounts;
  }
}
