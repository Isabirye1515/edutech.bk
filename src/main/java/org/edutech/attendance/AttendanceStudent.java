package org.edutech.attendance;

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
import java.util.List;

@Entity
@Table(name = "attendance")
public class AttendanceStudent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "school_id")
  private String schoolId;

  @Column(name = "attendance_name")
  private String attendanceName;

  @ManyToOne
  @JoinColumn(name = "attendance_stream_id")
  private AttendanceStream attendanceStream;

  @OneToMany(mappedBy = "attendanceStudent", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<Present> presents;

  public AttendanceStudent() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(String schoolId) {
    this.schoolId = schoolId;
  }

  public String getAttendanceName() {
    return attendanceName;
  }

  public void setAttendanceName(String attendanceName) {
    this.attendanceName = attendanceName;
  }

  public List<Present> getPresents() {
    return presents;
  }

  public void setPresents(List<Present> presents) {
    this.presents = presents;
  }

  public AttendanceStream getAttendanceStream() {
    return attendanceStream;
  }

  public void setAttendanceStream(AttendanceStream attendanceStream) {
    this.attendanceStream = attendanceStream;
  }
}
