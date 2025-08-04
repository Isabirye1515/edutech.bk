package org.edutech.timetable.dtos;

import java.sql.Time;
import org.edutech.timetable.TimeProgram;

public class TimeProgramDTO {

    private int id;
    private Time startTime;
    private Time endTime;
    private String title;
    private String event;
    private int TableStreamDTOId;

    public TimeProgramDTO() {}

    // Add this constructor for easy mapping from entity
    public TimeProgramDTO(TimeProgram timeProgram) {
        this.id = timeProgram.getId();
        this.startTime = timeProgram.getStartTime();
        this.endTime = timeProgram.getEndTime();
        this.title = timeProgram.getTitle();
        this.event = timeProgram.getEvent();
        if (timeProgram.getTableStream() != null) {
            this.TableStreamDTOId = timeProgram.getTableStream().getId();
        }
    }

    // Getters and setters...

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

    public int getTableStreamDTOId() {
        return TableStreamDTOId;
    }

    public void setTableStreamDTOId(int tableStreamDTOId) {
        TableStreamDTOId = tableStreamDTOId;
    }
}
