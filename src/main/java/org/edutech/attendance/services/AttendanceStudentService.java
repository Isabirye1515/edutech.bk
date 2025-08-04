package org.edutech.attendance.services;

import org.edutech.attendance.AttendanceStudent;
import org.edutech.attendance.daos.AttendanceStudentDao;
import org.edutech.attendance.dtos.AttendanceStudentDTO;
import org.edutech.attendance.dtos.PresentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AttendanceStudentService {

    @Autowired
    private AttendanceStudentDao attendanceStudentDao;

    public List<AttendanceStudentDTO> getAll() {
        return attendanceStudentDao.getAllAttendanceStudents().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AttendanceStudentDTO getById(int id) {
        return toDTO(attendanceStudentDao.getAttendanceStudentById(id));
    }

    public void save(AttendanceStudent student) {
        attendanceStudentDao.addAttendanceStudent(student);
    }

    public void update(AttendanceStudent student) {
        attendanceStudentDao.updateAttendanceStudent(student);
    }

    public void deleteById(int id) {
        attendanceStudentDao.deleteAttendanceStudentById(id);
    }

    public void deleteAll() {
        attendanceStudentDao.deleteAllAttendanceStudents();
    }

    public List<AttendanceStudent> findBySchoolId(String schoolId) {
        return attendanceStudentDao.findBySchoolId(schoolId);
    }

    public List<AttendanceStudent> findByStreamId(int streamId) {
        return attendanceStudentDao.findByStreamId(streamId);
    }

    public List<AttendanceStudent> findByAttendanceName(String name) {
        return attendanceStudentDao.findByAttendanceName(name);
    }

    // Helper method to convert entity to DTO
    private AttendanceStudentDTO toDTO(AttendanceStudent student) {
        AttendanceStudentDTO dto = new AttendanceStudentDTO();
        dto.setId(student.getId());
        dto.setSchoolId(student.getSchoolId());
        dto.setAttendanceName(student.getAttendanceName());
        dto.setPresents(
            student.getPresents().stream().map(present -> {
                PresentDTO presentDTO = new PresentDTO();
                presentDTO.setId(present.getId());
                presentDTO.setDay(present.getDay());
                presentDTO.setPresent(present.isPresent());
                presentDTO.setAttandenceStudentId(student.getId());
                return presentDTO;
            }).collect(Collectors.toList())
        );
        return dto;
    }
}
