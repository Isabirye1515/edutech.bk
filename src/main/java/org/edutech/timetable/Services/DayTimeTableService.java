package org.edutech.timetable.Services;

import java.util.List;

import org.edutech.timetable.DayTimeTable;
import org.edutech.timetable.TimeProgram;
import org.edutech.timetable.dao.DayTimeTableDao;
import org.edutech.timetable.dtos.DayTimeTableDTO;
import org.edutech.timetable.dtos.LessonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DayTimeTableService {
    @Autowired
    private DayTimeTableDao dayTimeTableDao; // Assuming you have a DAO for DayTimeTable

    
    public void saveDayTime(DayTimeTable dayTime) {
        dayTimeTableDao.saveDayTimeTable(dayTime);
    }

    
    public DayTimeTable getDayTimeById(int id) {
        return dayTimeTableDao.getDayTimeTableById(id);
    }

   
    public void updateDayTime(DayTimeTable dayTime) {
        dayTimeTableDao.updateDayTimeTable(dayTime);
    }

   
    public void deleteDayTime(int id) {
        dayTimeTableDao.deleteDayTimeTable(id);
    }

    
public List<DayTimeTableDTO> getAllDayTimeDTOs() {
    return dayTimeTableDao.getAllDayTimeTables()
            .stream()
            .map(this::mapToDTO)
            .toList();
}

public DayTimeTableDTO getDayTimeDTOById(int id) {
    DayTimeTable entity = dayTimeTableDao.getDayTimeTableById(id);
    return mapToDTO(entity);
}

// Mapping logic
private DayTimeTableDTO mapToDTO(DayTimeTable entity) {
    DayTimeTableDTO dto = new DayTimeTableDTO();
    dto.setId(entity.getId());
    dto.setDay(entity.getDay());
    dto.setFirstLesson(mapLesson(entity.getFirstLesson()));
    dto.setSecondLesson(mapLesson(entity.getSecondLesson()));
    dto.setBreakTime(mapLesson(entity.getBreakTime()));
    dto.setThirdLesson(mapLesson(entity.getThirdLesson()));
    dto.setFourthLesson(mapLesson(entity.getFourthLesson()));
    dto.setLunch(mapLesson(entity.getLunch()));
    dto.setFifthLesson(mapLesson(entity.getFifthLesson()));
    dto.setSixthLesson(mapLesson(entity.getSixthLesson()));
    dto.setTableStreamDTOId(entity.getTableStream().getId()); // assuming getter exists
    return dto;
}

private LessonDTO mapLesson(TimeProgram lesson) {
    if (lesson == null) return null;
    LessonDTO dto = new LessonDTO();
    dto.setId(lesson.getId());
    dto.setTitle(lesson.getTitle());
    dto.setEvent(lesson.getEvent());
    dto.setStartTime(lesson.getStartTime());
    dto.setEndTime(lesson.getEndTime());
    return dto;
}

    }

