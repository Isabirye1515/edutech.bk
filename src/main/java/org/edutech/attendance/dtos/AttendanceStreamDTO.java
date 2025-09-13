package org.edutech.attendance.dtos;

import java.util.List;

public class AttendanceStreamDTO {
  private int id;
  private String classRoom;
  private String streamName;
  private List<AttendanceStudentDTO> attendanceStudents;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getClassRoom() {
    return classRoom;
  }

  public void setClassRoom(String classRoom) {
    this.classRoom = classRoom;
  }

  public String getStreamName() {
    return streamName;
  }

  public void setStreamName(String streamName) {
    this.streamName = streamName;
  }

  public List<AttendanceStudentDTO> getAttendanceStudents() {
    return attendanceStudents;
  }

  public void setAttendanceStudents(List<AttendanceStudentDTO> attendanceStudents) {
    this.attendanceStudents = attendanceStudents;
  }
}
