package org.edutech.timetable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prep_time_table")
public class PrepTimeTable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "day")
  private String day;

  @OneToOne
  @JoinColumn(name = "first_lesson")
  private TimeProgram firstLesson;

  @OneToOne
  @JoinColumn(name = "second_lesson")
  private TimeProgram secondLesson;

  @OneToOne
  @JoinColumn(name = "break_time")
  private TimeProgram breakTime;

  @ManyToOne
  @JoinColumn(name = "table_stream_id")
  private TableStream tableStream;

  public PrepTimeTable() {}

  public TimeProgram getFirstLesson() {
    return firstLesson;
  }

  public void setFirstLesson(TimeProgram firstLesson) {
    this.firstLesson = firstLesson;
  }

  public TimeProgram getSecondLesson() {
    return secondLesson;
  }

  public void setSecondLesson(TimeProgram secondLesson) {
    this.secondLesson = secondLesson;
  }

  public TimeProgram getBreakTime() {
    return breakTime;
  }

  public void setBreakTime(TimeProgram breakTime) {
    this.breakTime = breakTime;
  }

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

  public TableStream getTableStream() {
    return tableStream;
  }

  public void setTableStream(TableStream tableStream) {
    this.tableStream = tableStream;
  }
}
