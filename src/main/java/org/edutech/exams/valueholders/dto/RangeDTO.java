package org.edutech.exams.valueholders.dto;

public class RangeDTO {
  private int id;
  private double from;
  private double to;
  private String credit;

  // Getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getFrom() {
    return from;
  }

  public void setFrom(double from) {
    this.from = from;
  }

  public double getTo() {
    return to;
  }

  public void setTo(double to) {
    this.to = to;
  }

  public String getCredit() {
    return credit;
  }

  public void setCredit(String credit) {
    this.credit = credit;
  }
}
