package org.edutech.timetable.Services;

import java.util.List;
import org.edutech.timetable.TimeProgram;
import org.edutech.timetable.dtos.TimeProgramDTO;

public interface TimeProgramService {
  void saveTimeProgram(TimeProgram timeProgram);

  TimeProgram getTimeProgramById(int id);

  void updateTimeProgram(TimeProgram timeProgram);

  void deleteTimeProgram(int id);

  List<TimeProgram> getAllTimePrograms();

  TimeProgramDTO getTimeProgramDTO(int id);

  List<TimeProgramDTO> getAllDTO();
}
