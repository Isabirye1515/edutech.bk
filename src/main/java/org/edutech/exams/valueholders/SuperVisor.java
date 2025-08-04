package org.edutech.exams.valueholders;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table( name = "supervisor")
public class SuperVisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "paper_name")
    private String paperName;
     @Column(name = "visor_name")
    private String visorName;
     @Column(name = "start_at")
    private Time startAt;
     @Column(name = "end_at")
    private Time endAt;
     @Column(name = "day")
    private Date day;
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public SuperVisor(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getVisorName() {
        return visorName;
    }

    public void setVisorName(String visorName) {
        this.visorName = visorName;
    }

    public Time getStartAt() {
        return startAt;
    }

    public void setStartAt(Time startAt) {
        this.startAt = startAt;
    }

    public Time getEndAt() {
        return endAt;
    }

    public void setEndAt(Time endAt) {
        this.endAt = endAt;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    


    
}
