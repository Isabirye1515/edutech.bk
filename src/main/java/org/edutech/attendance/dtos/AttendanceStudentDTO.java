package org.edutech.attendance.dtos;

import java.util.List;

public class AttendanceStudentDTO {
  private int id;
  private String schoolId;
  private String attendanceName;
  private List<PresentDTO> presents;

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

  public List<PresentDTO> getPresents() {
    return presents;
  }

  public void setPresents(List<PresentDTO> presents) {
    this.presents = presents;
  }
}
