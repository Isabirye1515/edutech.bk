package org.edutech.timetable.Services;

import org.edutech.timetable.*;
import org.edutech.timetable.dao.TableStreamDao;
import org.edutech.timetable.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableStreamService {

    @Autowired
    private TableStreamDao tableStreamDao;

    @Transactional
    public List<TableStreamDTO> getAll() {
        return tableStreamDao.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TableStreamDTO getById(int id) {
        TableStream ts = tableStreamDao.findById(id);
        if (ts == null) return null;
        return mapToDTO(ts);
    }

    @Transactional
    public void addTableStream(TableStream tableStream){
        tableStreamDao.save(tableStream);
    }

    @Transactional
    public void updateStreamTable(TableStream tableStream){
        tableStreamDao.update(tableStream);
    }

    @Transactional
    public void deleteStreamTable(int id){
        tableStreamDao.delete(id);
    }

    private TableStreamDTO mapToDTO(TableStream ts) {
        TableStreamDTO dto = new TableStreamDTO();
        dto.setId(ts.getId());
        dto.setClassName(ts.getClassName());
        dto.setStreamName(ts.getStreamName());

        // Map timePrograms list
        if (ts.getTimePrograms() != null) {
            dto.setTimePrograms(
                ts.getTimePrograms().stream()
                  .map(this::mapTimeProgramToDTO)
                  .collect(Collectors.toList())
            );
        }

        if (ts.getDayTimeTables() != null) {
            dto.setDayTimeTables(ts.getDayTimeTables().stream()
                .map(this::mapDayTimeTableToDTO)
                .collect(Collectors.toList()));
        }

        if (ts.getPrepTimeTable() != null) {
            dto.setPrepTimeTables(ts.getPrepTimeTable().stream()
                .map(this::mapPrepTimeTableToDTO)
                .collect(Collectors.toList()));
        }

        if (ts.getWeekendTimeTables() != null) {
            dto.setWeekendTimeTables(ts.getWeekendTimeTables().stream()
                .map(this::mapWeekendTimeTableToDTO)
                .collect(Collectors.toList()));
        }

        return dto;
    }

    private DayTimeTableDTO mapDayTimeTableToDTO(DayTimeTable dt) {
        DayTimeTableDTO dtd = new DayTimeTableDTO();
        dtd.setId(dt.getId());
        dtd.setDay(dt.getDay());
        dtd.setTableStreamDTOId(dt.getTableStream().getId());

        dtd.setFirstLesson(mapTimeProgramToLessonDTO(dt.getFirstLesson()));
        dtd.setSecondLesson(mapTimeProgramToLessonDTO(dt.getSecondLesson()));
        dtd.setBreakTime(mapTimeProgramToLessonDTO(dt.getBreakTime()));
        dtd.setThirdLesson(mapTimeProgramToLessonDTO(dt.getThirdLesson()));
        dtd.setFourthLesson(mapTimeProgramToLessonDTO(dt.getFourthLesson()));
        dtd.setLunch(mapTimeProgramToLessonDTO(dt.getLunch()));
        dtd.setFifthLesson(mapTimeProgramToLessonDTO(dt.getFifthLesson()));
        dtd.setSixthLesson(mapTimeProgramToLessonDTO(dt.getSixthLesson()));

        return dtd;
    }

    private PrepTimeTableDTO mapPrepTimeTableToDTO(PrepTimeTable pt) {
        PrepTimeTableDTO ptd = new PrepTimeTableDTO();
        ptd.setId(pt.getId());
        ptd.setDay(pt.getDay());
        ptd.setTableStreamDTOId(pt.getTableStream().getId());

        ptd.setFirstLesson(mapTimeProgramToLessonDTO(pt.getFirstLesson()));
        ptd.setSecondLesson(mapTimeProgramToLessonDTO(pt.getSecondLesson()));
        ptd.setBreakTime(mapTimeProgramToLessonDTO(pt.getBreakTime()));

        return ptd;
    }

    private WeekendTimeTableDTO mapWeekendTimeTableToDTO(WeekendTimeTable wt) {
        WeekendTimeTableDTO wtd = new WeekendTimeTableDTO();
        wtd.setId(wt.getId());
        wtd.setDay(wt.getDay());
        wtd.setTableStreamDTOId(wt.getTableStream().getId());

        wtd.setFirstLesson(mapTimeProgramToLessonDTO(wt.getFirstLesson()));
        wtd.setSecondLesson(mapTimeProgramToLessonDTO(wt.getSecondLesson()));
        wtd.setBreakTime(mapTimeProgramToLessonDTO(wt.getBreakTime()));
        wtd.setThirdLesson(mapTimeProgramToLessonDTO(wt.getThirdLesson()));
        wtd.setFourthLesson(mapTimeProgramToLessonDTO(wt.getFourthLesson()));
        wtd.setLunch(mapTimeProgramToLessonDTO(wt.getLunch()));
        wtd.setFifthLesson(mapTimeProgramToLessonDTO(wt.getFifthLesson()));
        wtd.setSixthLesson(mapTimeProgramToLessonDTO(wt.getSixthLesson()));

        return wtd;
    }

    private LessonDTO mapTimeProgramToLessonDTO(TimeProgram tp) {
        if (tp == null) return null;
        LessonDTO lesson = new LessonDTO();
        lesson.setId(tp.getId());
        lesson.setTitle(tp.getTitle());
        lesson.setEvent(tp.getEvent());
        lesson.setStartTime(tp.getStartTime());
        lesson.setEndTime(tp.getEndTime());
        return lesson;
    }

    private TimeProgramDTO mapTimeProgramToDTO(TimeProgram tp) {
        if (tp == null) return null;
        TimeProgramDTO dto = new TimeProgramDTO();
        dto.setId(tp.getId());
        dto.setTitle(tp.getTitle());
        dto.setEvent(tp.getEvent());
        dto.setStartTime(tp.getStartTime());
        dto.setEndTime(tp.getEndTime());
        return dto;
    }
}
