package org.edutech.attendance;

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
@Table(name = "attendance_stream")
public class AttendanceStream {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    @Column(name = "classroom")
    private String classRoom;
    @Column(name = "stream_name")
    private String streamName;
    @OneToMany(mappedBy = "attendanceStream", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendanceStudent> attendanceStudents;

    public AttendanceStream(){}

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

    public List<AttendanceStudent> getAttendanceStudents() {
        return attendanceStudents;
    }

    public void setAttendanceStudents(List<AttendanceStudent> attendanceStudents) {
        this.attendanceStudents = attendanceStudents;
    }

    
    
}
