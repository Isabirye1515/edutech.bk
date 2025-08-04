package org.edutech.timetable;

import javax.persistence.*;

@Entity
@Table(name = "day_time_table")
public class DayTimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "day")
    private String day;

    @OneToOne
    @JoinColumn(name = "first_lesson_id")
    private TimeProgram firstLesson;

    @OneToOne
    @JoinColumn(name = "second_lesson_id")
    private TimeProgram secondLesson;

    @OneToOne
    @JoinColumn(name = "break_time_id")
    private TimeProgram breakTime;

    @OneToOne
    @JoinColumn(name = "third_lesson_id")
    private TimeProgram thirdLesson;

    @OneToOne
    @JoinColumn(name = "fourth_lesson_id")
    private TimeProgram fourthLesson;

    @OneToOne
    @JoinColumn(name = "lunch_id")
    private TimeProgram lunch;

    @OneToOne
    @JoinColumn(name = "fifth_lesson_id")
    private TimeProgram fifthLesson;

    @OneToOne
    @JoinColumn(name = "sixth_lesson_id")
    private TimeProgram sixthLesson;

    @ManyToOne
    @JoinColumn(name = "table_stream_id")
    private TableStream tableStream;

    public DayTimeTable() {}

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

    public TableStream getTableStream() {
        return tableStream;
    }

    public void setTableStream(TableStream tableStream) {
        this.tableStream = tableStream;
    }
    
}
