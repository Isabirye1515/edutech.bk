package org.edutech.timetable.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.edutech.timetable.PrepTimeTable;
import org.edutech.timetable.TimeProgram;
import org.edutech.timetable.dao.PrepTimeTableDao;
import org.edutech.timetable.dtos.LessonDTO;
import org.edutech.timetable.dtos.PrepTimeTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrepTimeTableServiceImpl implements PrepTimeTableService {

    @Autowired
    private PrepTimeTableDao prepTimeTableDao;

    @Override
    public void savePrepTimeTable(PrepTimeTable prepTimeTable) {
        prepTimeTableDao.savePrepTimeTable(prepTimeTable);
    }

    @Override
    public PrepTimeTableDTO getPrepTimeTableDTOById(int id) {
        PrepTimeTable entity = prepTimeTableDao.getPrepTimeTableById(id);
        return toDTO(entity);
    }
    @Override
    public PrepTimeTable getPrepTimeTableById(int id){
        PrepTimeTable prepTimeTable = prepTimeTableDao.getPrepTimeTableById(id);
        return prepTimeTable;

    }

    @Override
    public void updatePrepTimeTable(PrepTimeTable prepTimeTable) {
        prepTimeTableDao.updatePrepTimeTable(prepTimeTable);
    }

    @Override
    public void deletePrepTimeTable(int id) {
        prepTimeTableDao.deletePrepTimeTable(id);
    }

    @Override
    public List<PrepTimeTableDTO> getAllPrepTimeTables() {
        return prepTimeTableDao.getAllPrepTimeTables().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PrepTimeTable getPrepTimeTableByDay(String day) {
        return prepTimeTableDao.getPrepTimeTableByDay(day); // Keeping this returning entity
    }

    private PrepTimeTableDTO toDTO(PrepTimeTable entity) {
        if (entity == null) return null;

        PrepTimeTableDTO dto = new PrepTimeTableDTO();
        dto.setId(entity.getId());
        dto.setDay(entity.getDay());
        dto.setFirstLesson(toLessonDTO(entity.getFirstLesson()));
        dto.setSecondLesson(toLessonDTO(entity.getSecondLesson()));
        dto.setBreakTime(toLessonDTO(entity.getBreakTime()));
        dto.setTableStreamDTOId(entity.getTableStream().getId());
        return dto;
    }

    private LessonDTO toLessonDTO(TimeProgram lesson) {
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
