package org.edutech.timetable.Services;

import java.util.List;
import org.edutech.timetable.PrepTimeTable;
import org.edutech.timetable.dtos.PrepTimeTableDTO;

public interface PrepTimeTableService {
  void savePrepTimeTable(PrepTimeTable prepTimeTable);

  PrepTimeTable getPrepTimeTableById(int id);

  PrepTimeTableDTO getPrepTimeTableDTOById(int id);

  void updatePrepTimeTable(PrepTimeTable prepTimeTable);

  void deletePrepTimeTable(int id);

  List<PrepTimeTableDTO> getAllPrepTimeTables();

  PrepTimeTable getPrepTimeTableByDay(String day);
}
