package org.edutech.exams.valueholders;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "begin_on")
    private Date beginOn;
    @Column(name = "end_on")
    private Date endOn;
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExamStudent> examStudents;
    
    @OneToMany(mappedBy = "exam" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SuperVisor> supervisors;

    public Exam(){}

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
    public Date getBeginOn() {
        return beginOn;
    }
    public void setBeginOn(Date beginOn) {
        this.beginOn = beginOn;
    }
    public Date getEndOn() {
        return endOn;
    }
    public void setEndOn(Date endOn) {
        this.endOn = endOn;
    }
    public Set<SuperVisor> getSupervisors() {
        return supervisors;
    }
    public void setSupervisors(Set<SuperVisor> supervisors) {
        this.supervisors = supervisors;
    }

    public Set<ExamStudent> getExamStudents() {
        return examStudents;
    }

    public void setExamStudents(Set<ExamStudent> examStudents) {
        this.examStudents = examStudents;
    }

    
    
    
    
}
