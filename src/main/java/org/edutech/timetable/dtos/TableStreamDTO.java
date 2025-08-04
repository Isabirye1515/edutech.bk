package org.edutech.timetable.dtos;

import java.util.List;

public class TableStreamDTO {
    private int id;
    private String className;
    private String streamName;
    private List<TimeProgramDTO> timePrograms;
    private List<DayTimeTableDTO> dayTimeTables;
    private List<PrepTimeTableDTO> prepTimeTables;
    private List<WeekendTimeTableDTO> weekendTimeTables;


    public TableStreamDTO() {}

    



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }



    public List<TimeProgramDTO> getTimePrograms() {
        return timePrograms;
    }



    public void setTimePrograms(List<TimeProgramDTO> timePrograms) {
        this.timePrograms = timePrograms;
    }



    public List<DayTimeTableDTO> getDayTimeTables() {
        return dayTimeTables;
    }



    public void setDayTimeTables(List<DayTimeTableDTO> dayTimeTables) {
        this.dayTimeTables = dayTimeTables;
    }



    public List<PrepTimeTableDTO> getPrepTimeTables() {
        return prepTimeTables;
    }



    public void setPrepTimeTables(List<PrepTimeTableDTO> prepTimeTables) {
        this.prepTimeTables = prepTimeTables;
    }



    public List<WeekendTimeTableDTO> getWeekendTimeTables() {
        return weekendTimeTables;
    }



    public void setWeekendTimeTables(List<WeekendTimeTableDTO> weekendTimeTables) {
        this.weekendTimeTables = weekendTimeTables;
    }

    
}
