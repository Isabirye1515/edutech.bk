package org.edutech.attendance.services;

import org.edutech.attendance.AttendanceStream;
import org.edutech.attendance.daos.AttendanceStreamDao;
import org.edutech.attendance.dtos.AttendanceStreamDTO;
import org.edutech.attendance.dtos.AttendanceStudentDTO;
import org.edutech.attendance.dtos.PresentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AttendanceStreamService {

    @Autowired
    private AttendanceStreamDao attendanceStreamDao;

    public List<AttendanceStreamDTO> getAll() {
        return attendanceStreamDao.getAllStreams().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AttendanceStreamDTO getById(int id) {
        return toDTO(attendanceStreamDao.getStreamById(id));
    }

    public void save(AttendanceStream stream) {
        attendanceStreamDao.addAttendanceStream(stream);
    }

    public void update(AttendanceStream stream) {
     attendanceStreamDao.updateStream(stream);
    }

    public void deleteById(int id) {
        attendanceStreamDao.deleteStreamById(id);
    }

    public void deleteAll() {
        attendanceStreamDao.deleteAllStreams();
    }

    // DTO conversion helper
    private AttendanceStreamDTO toDTO(AttendanceStream stream) {
        AttendanceStreamDTO dto = new AttendanceStreamDTO();
        dto.setId(stream.getId());
        dto.setClassRoom(stream.getClassRoom());
        dto.setStreamName(stream.getStreamName());
        dto.setAttendanceStudents(
            stream.getAttendanceStudents().stream().map(student -> {
                AttendanceStudentDTO studentDTO = new AttendanceStudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setSchoolId(student.getSchoolId());
                studentDTO.setAttendanceName(student.getAttendanceName());
                studentDTO.setPresents(
                    student.getPresents().stream().map(present -> {
                        PresentDTO presentDTO = new PresentDTO();
                        presentDTO.setId(present.getId());
                        presentDTO.setDay(present.getDay());
                        presentDTO.setPresent(present.isPresent());
                        presentDTO.setAttandenceStudentId(student.getId());
                        return presentDTO;
                    }).collect(Collectors.toList())
                );
                return studentDTO;
            }).collect(Collectors.toList())
        );
        return dto;
    }
}
