package org.edutech.subject.valueholder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "subject_paper")
public class SubjectPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "paper_name")
    private String paperName;
    @Column(name = "paper_code")
    private String paperCode;
    @Column(name = "is_option")
    private boolean isOption;
    @Column(name = "has_teacher")
    private boolean hasTeacher;

    public SubjectPaper(){}

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

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    public boolean isOption() {
        return isOption;
    }

    public void setOption(boolean isOption) {
        this.isOption = isOption;
    }

    public boolean isHasTeacher() {
        return hasTeacher;
    }

    public void setHasTeacher(boolean hasTeacher) {
        this.hasTeacher = hasTeacher;
    }

    
    
}
