package org.edutech.exams.valueholders.dto;

import java.util.List;

public class ExamStudentDTO {
    private int id;
    private String studentName;
    private String streamName;
    private List<PaperRequestDTO> papers;
    private int examId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public List<PaperRequestDTO> getPapers() {
        return papers;
    }

    public void setPapers(List<PaperRequestDTO> papers) {
        this.papers = papers;
    }
}
