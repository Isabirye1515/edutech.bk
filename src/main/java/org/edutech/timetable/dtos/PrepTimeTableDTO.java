package org.edutech.timetable.dtos;

public class PrepTimeTableDTO {

  private int id;

  private String day;

  private LessonDTO firstLesson;

  private LessonDTO secondLesson;

  private LessonDTO breakTime;

  private int tableStreamDTOId;

  public PrepTimeTableDTO() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public LessonDTO getFirstLesson() {
    return firstLesson;
  }

  public void setFirstLesson(LessonDTO firstLesson) {
    this.firstLesson = firstLesson;
  }

  public LessonDTO getSecondLesson() {
    return secondLesson;
  }

  public void setSecondLesson(LessonDTO secondLesson) {
    this.secondLesson = secondLesson;
  }

  public LessonDTO getBreakTime() {
    return breakTime;
  }

  public void setBreakTime(LessonDTO breakTime) {
    this.breakTime = breakTime;
  }

  public int getTableStreamDTOId() {
    return tableStreamDTOId;
  }

  public void setTableStreamDTOId(int tableStreamDTOId) {
    this.tableStreamDTOId = tableStreamDTOId;
  }
}
