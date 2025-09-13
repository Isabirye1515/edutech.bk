package org.edutech.timetable;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "time_program")
public class TimeProgram {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "start_time")
  private Time startTime;

  @Column(name = "end_time")
  private Time endTime;

  @Column(name = "title")
  private String title;

  @Column(name = "event")
  private String event;

  @ManyToOne
  @JoinColumn(name = "table_stream_id")
  private TableStream tableStream;

  public TimeProgram() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Time getStartTime() {
    return startTime;
  }

  public void setStartTime(Time startTime) {
    this.startTime = startTime;
  }

  public Time getEndTime() {
    return endTime;
  }

  public void setEndTime(Time endTime) {
    this.endTime = endTime;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public TableStream getTableStream() {
    return tableStream;
  }

  public void setTableStream(TableStream tableStream) {
    this.tableStream = tableStream;
  }
}
