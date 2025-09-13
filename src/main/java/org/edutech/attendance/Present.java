package org.edutech.attendance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "present")
public class Present {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "day")
  private Date day;

  @Column(name = "is_present")
  private boolean isPresent;

  @ManyToOne
  @JoinColumn(name = "attendance_id")
  private AttendanceStudent attendanceStudent;

  public Present() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDay() {
    return day;
  }

  public void setDay(Date day) {
    this.day = day;
  }

  public boolean isPresent() {
    return isPresent;
  }

  public void setPresent(boolean isPresent) {
    this.isPresent = isPresent;
  }

  public AttendanceStudent getAttendanceStudent() {
    return attendanceStudent;
  }

  public void setAttendanceStudent(AttendanceStudent attendanceStudent) {
    this.attendanceStudent = attendanceStudent;
  }
}
