package org.edutech.timetable.dtos;

import java.sql.Time;

public class LessonDTO {
    private int id;
    private String title;
    private String event;
    private Time startTime;
    private Time endTime;

    public LessonDTO() {
    }

    public LessonDTO(int id, String title, String event, Time startTime, Time endTime) {
        this.id = id;
        this.title = title;
        this.event = event;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
