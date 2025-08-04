package org.edutech.timetable.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.edutech.timetable.TimeProgram;
import org.edutech.timetable.dao.TimeProgramDao;
import org.edutech.timetable.dtos.TimeProgramDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeProgramServiceImpl implements TimeProgramService {

    @Autowired
    private TimeProgramDao timeProgramDao;

    @Override
    public void saveTimeProgram(TimeProgram timeProgram) {
        timeProgramDao.saveTimeProgram(timeProgram);
    }

    @Override
    public TimeProgram getTimeProgramById(int id) {
        return timeProgramDao.getTimeProgramById(id);
    }

    @Override
    public void updateTimeProgram(TimeProgram timeProgram) {
        timeProgramDao.updateTimeProgram(timeProgram);
    }

    @Override
    public void deleteTimeProgram(int id) {
        timeProgramDao.deleteTimeProgram(id);
    }

    @Override
    public List<TimeProgram> getAllTimePrograms() {
        return timeProgramDao.getAllTimePrograms();
    }

    public TimeProgramDTO getTimeProgramDTO(int id) {
        TimeProgram entity = timeProgramDao.getTimeProgramById(id);
        if (entity == null) return null;
        return new TimeProgramDTO(entity);
    }

    @Override
    public List<TimeProgramDTO> getAllDTO() {
        return timeProgramDao.getAllTimePrograms()
            .stream()
            .map(TimeProgramDTO::new)
            .collect(Collectors.toList());
    }
}
