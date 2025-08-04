package org.edutech.attendance;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "present")
public class Present {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "day")
    private Date day;
    @Column(name = "is_present")
    private boolean isPresent;
    @ManyToOne
    @JoinColumn(name = "attendance_id")
    private AttendanceStudent attendanceStudent;

    public Present(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public AttendanceStudent getAttendanceStudent() {
        return attendanceStudent;
    }

    public void setAttendanceStudent(AttendanceStudent attendanceStudent) {
        this.attendanceStudent = attendanceStudent;
    }

    
    
}
