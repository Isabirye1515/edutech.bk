package org.edutech.Student.services;

import org.edutech.Student.valueholder.Student;
import org.edutech.Student.valueholder.dtos.StudentDTO;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void deleteStudent(int id);
    void updateStudent(Student student);
    List<StudentDTO> getAllStudentDTOS();
    StudentDTO getStudentDTOById(int id);
}
