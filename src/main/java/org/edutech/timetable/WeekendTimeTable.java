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
@Table(name = "weekend")
public class WeekendTimeTable {
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

  @OneToOne
  @JoinColumn(name = "third_lesson")
  private TimeProgram thirdLesson;

  @OneToOne
  @JoinColumn(name = "fourth_lesson")
  private TimeProgram fourthLesson;

  @OneToOne
  @JoinColumn(name = "lunch")
  private TimeProgram lunch;

  @OneToOne
  @JoinColumn(name = "fifth_lesson")
  private TimeProgram fifthLesson;

  @OneToOne
  @JoinColumn(name = "sixth_lesson")
  private TimeProgram sixthLesson;

  @ManyToOne
  @JoinColumn(name = "table_stream_id")
  private TableStream tableStream;

  public WeekendTimeTable() {}

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

  public TimeProgram getThirdLesson() {
    return thirdLesson;
  }

  public void setThirdLesson(TimeProgram thirdLesson) {
    this.thirdLesson = thirdLesson;
  }

  public TimeProgram getFourthLesson() {
    return fourthLesson;
  }

  public void setFourthLesson(TimeProgram fourthLesson) {
    this.fourthLesson = fourthLesson;
  }

  public TimeProgram getLunch() {
    return lunch;
  }

  public void setLunch(TimeProgram lunch) {
    this.lunch = lunch;
  }

  public TimeProgram getFifthLesson() {
    return fifthLesson;
  }

  public void setFifthLesson(TimeProgram fifthLesson) {
    this.fifthLesson = fifthLesson;
  }

  public TimeProgram getSixthLesson() {
    return sixthLesson;
  }

  public void setSixthLesson(TimeProgram sixthLesson) {
    this.sixthLesson = sixthLesson;
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
