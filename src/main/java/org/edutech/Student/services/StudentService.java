package org.edutech.Student.services;

import java.util.List;
import org.edutech.Student.valueholder.Student;
import org.edutech.Student.valueholder.dtos.StudentDTO;

public interface StudentService {
  void addStudent(Student student);

  List<Student> getAllStudents();

  Student getStudentById(int id);

  void deleteStudent(int id);

  void updateStudent(Student student);

  List<StudentDTO> getAllStudentDTOS();

  StudentDTO getStudentDTOById(int id);
}
