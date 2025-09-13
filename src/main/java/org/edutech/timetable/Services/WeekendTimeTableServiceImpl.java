package org.edutech.timetable.Services;

import java.util.List;
import java.util.stream.Collectors;
import org.edutech.timetable.TimeProgram;
import org.edutech.timetable.WeekendTimeTable;
import org.edutech.timetable.dao.WeekendTimeTableDao;
import org.edutech.timetable.dtos.LessonDTO;
import org.edutech.timetable.dtos.WeekendTimeTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekendTimeTableServiceImpl implements WeekendTimeTableService {

  @Autowired private WeekendTimeTableDao weekendTimeTableDao;

  @Override
  public void saveWeekendTimeTable(WeekendTimeTable weekendTimeTable) {
    weekendTimeTableDao.saveWeekendTimeTable(weekendTimeTable);
  }

  @Override
  public WeekendTimeTable getWeekendTimeTableById(int id) {
    WeekendTimeTable entity = weekendTimeTableDao.getWeekendTimeTableById(id);
    return entity;
  }

  @Override
  public void updateWeekendTimeTable(WeekendTimeTable weekendTimeTable) {
    weekendTimeTableDao.updateWeekendTimeTable(weekendTimeTable);
  }

  @Override
  public void deleteWeekendTimeTable(int id) {
    weekendTimeTableDao.deleteWeekendTimeTable(id);
  }

  @Override
  public List<WeekendTimeTableDTO> getAllWeekendTimeTables() {
    return weekendTimeTableDao.getAllWeekendTimeTables().stream()
        .map(this::mapToDTO)
        .collect(Collectors.toList());
  }

  @Override
  public WeekendTimeTableDTO getWeekendTimeTableDTOById(int id) {
    WeekendTimeTable entity = weekendTimeTableDao.getWeekendTimeTableById(id);
    return mapToDTO(entity);
  }

  private WeekendTimeTableDTO mapToDTO(WeekendTimeTable entity) {
    WeekendTimeTableDTO dto = new WeekendTimeTableDTO();
    dto.setId(entity.getId());
    dto.setDay(entity.getDay());

    dto.setFirstLesson(toLessonDTO(entity.getFirstLesson()));
    dto.setSecondLesson(toLessonDTO(entity.getSecondLesson()));
    dto.setBreakTime(toLessonDTO(entity.getBreakTime()));
    dto.setThirdLesson(toLessonDTO(entity.getThirdLesson()));
    dto.setFourthLesson(toLessonDTO(entity.getFourthLesson()));
    dto.setLunch(toLessonDTO(entity.getLunch()));
    dto.setFifthLesson(toLessonDTO(entity.getFifthLesson()));
    dto.setSixthLesson(toLessonDTO(entity.getSixthLesson()));

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
