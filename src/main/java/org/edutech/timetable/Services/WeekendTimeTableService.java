package org.edutech.timetable.Services;

import java.util.List;

import org.edutech.timetable.WeekendTimeTable;
import org.edutech.timetable.dtos.WeekendTimeTableDTO;

public interface WeekendTimeTableService {
    void saveWeekendTimeTable(WeekendTimeTable weekendTimeTable);
     WeekendTimeTable getWeekendTimeTableById(int id);
    void updateWeekendTimeTable(WeekendTimeTable weekendTimeTable);
    void deleteWeekendTimeTable(int id);
   
    List<WeekendTimeTableDTO> getAllWeekendTimeTables();   // Now returns DTOs
    WeekendTimeTableDTO getWeekendTimeTableDTOById(int id);
    
}
