package org.edutech.Student.services;

import java.util.List;
import org.edutech.Student.valueholder.BordingStudent;
import org.edutech.Student.valueholder.dtos.BordingStudentDTO;

public interface BordingStudentService {
  void addBordingStudent(BordingStudent bordingStudent);

  List<BordingStudent> getAllBordingStudents();

  BordingStudent getBordingStudentById(int id);

  void deleteBordingStudent(int id);

  void updateBordingStudent(BordingStudent bordingStudent);

  List<BordingStudentDTO> getAllBordingStudentDtos();

  BordingStudentDTO getBordingStudentDtoById(int id);
}
