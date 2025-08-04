package org.edutech.timetable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stream_table")
public class TableStream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "class_name")
    private String className;
    @Column(name = "stream_name")
    private String streamName;
    @OneToMany(mappedBy ="tableStream", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<TimeProgram> timePrograms;
     @OneToMany(mappedBy ="tableStream", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<WeekendTimeTable> weekendTimeTables;
     @OneToMany(mappedBy ="tableStream", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<DayTimeTable> dayTimeTables;
     @OneToMany(mappedBy ="tableStream", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<PrepTimeTable> prepTimeTable;

    public TableStream(){}

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

    public List<TimeProgram> getTimePrograms() {
        return timePrograms;
    }

    public void setTimePrograms(List<TimeProgram> timePrograms) {
        this.timePrograms = timePrograms;
    }

    public List<WeekendTimeTable> getWeekendTimeTables() {
        return weekendTimeTables;
    }

    public void setWeekendTimeTables(List<WeekendTimeTable> weekendTimeTables) {
        this.weekendTimeTables = weekendTimeTables;
    }

    public List<DayTimeTable> getDayTimeTables() {
        return dayTimeTables;
    }

    public void setDayTimeTables(List<DayTimeTable> dayTimeTables) {
        this.dayTimeTables = dayTimeTables;
    }

    public List<PrepTimeTable> getPrepTimeTable() {
        return prepTimeTable;
    }

    public void setPrepTimeTable(List<PrepTimeTable> prepTimeTable) {
        this.prepTimeTable = prepTimeTable;
    }
    
    
}
