package org.edutech.timetable.dtos;

public class DayTimeTableDTO {

    private int id;

    private String day;

    private LessonDTO firstLesson;

    private LessonDTO secondLesson;

    private LessonDTO breakTime;

    private LessonDTO thirdLesson;

    private LessonDTO fourthLesson;

    private LessonDTO lunch;

    private LessonDTO fifthLesson;

    private LessonDTO sixthLesson;

    private int tableStreamDTOId;

    public DayTimeTableDTO() {}

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

    public LessonDTO getFirstLesson() {
        return firstLesson;
    }

    public void setFirstLesson(LessonDTO firstLesson) {
        this.firstLesson = firstLesson;
    }

    public LessonDTO getSecondLesson() {
        return secondLesson;
    }

    public void setSecondLesson(LessonDTO secondLesson) {
        this.secondLesson = secondLesson;
    }

    public LessonDTO getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(LessonDTO breakTime) {
        this.breakTime = breakTime;
    }

    public LessonDTO getThirdLesson() {
        return thirdLesson;
    }

    public void setThirdLesson(LessonDTO thirdLesson) {
        this.thirdLesson = thirdLesson;
    }

    public LessonDTO getFourthLesson() {
        return fourthLesson;
    }

    public void setFourthLesson(LessonDTO fourthLesson) {
        this.fourthLesson = fourthLesson;
    }

    public LessonDTO getLunch() {
        return lunch;
    }

    public void setLunch(LessonDTO lunch) {
        this.lunch = lunch;
    }

    public LessonDTO getFifthLesson() {
        return fifthLesson;
    }

    public void setFifthLesson(LessonDTO fifthLesson) {
        this.fifthLesson = fifthLesson;
    }

    public LessonDTO getSixthLesson() {
        return sixthLesson;
    }

    public void setSixthLesson(LessonDTO sixthLesson) {
        this.sixthLesson = sixthLesson;
    }

    public int getTableStreamDTOId() {
        return tableStreamDTOId;
    }

    public void setTableStreamDTOId(int tableStreamDTOId) {
        this.tableStreamDTOId = tableStreamDTOId;
    }
}
