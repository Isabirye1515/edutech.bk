package org.edutech.exams.valueholders.dto;

import java.util.List;

public class PaperRequestDTO {
    private int id;
    private String abrev;
    private String paperName;
    private List<MarksDTO> marks;
    private int examStudentId;

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }


    public List<MarksDTO> getMarks() {
        return marks;
    }

    public void setMarks(List<MarksDTO> marks) {
        this.marks = marks;
    }

    public int getExamStudentId() {
        return examStudentId;
    }

    public void setExamStudentId(int examStudentId) {
        this.examStudentId = examStudentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
