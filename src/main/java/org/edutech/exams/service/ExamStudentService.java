package org.edutech.exams.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.edutech.exams.dao.ExamStudentDao;
import org.edutech.exams.valueholders.ExamStudent;
import org.edutech.exams.valueholders.Marks;
import org.edutech.exams.valueholders.Paper;
import org.edutech.exams.valueholders.dto.ExamStudentDTO;
import org.edutech.exams.valueholders.dto.MarksDTO;
import org.edutech.exams.valueholders.dto.PaperRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamStudentService {

  @Autowired private ExamStudentDao examStudentDao;

  @Transactional
  public List<ExamStudentDTO> getAllExamStudents() {
    return examStudentDao.findAll().stream().map(this::toDto).collect(Collectors.toList());
  }

  @Transactional
  public ExamStudentDTO getExamStudentById(int id) {
    ExamStudent student = examStudentDao.findById(id);
    if (student == null) throw new RuntimeException("ExamStudent not found");
    return toDto(student);
  }

  @Transactional
  public void createExamStudent(ExamStudent examStudent) {
    examStudentDao.save(examStudent);
  }

  @Transactional
  public void updateExamStudent(ExamStudent examStudent) {
    ExamStudent existing = examStudentDao.findById(examStudent.getId());
    if (existing == null) throw new RuntimeException("ExamStudent not found");
    examStudentDao.update(examStudent);
  }

  @Transactional
  public void deleteExamStudent(int id) {
    examStudentDao.deleteById(id);
  }

  private ExamStudentDTO toDto(ExamStudent student) {
    ExamStudentDTO dto = new ExamStudentDTO();
    dto.setId(student.getId());
    dto.setStudentName(student.getStudentName());
    dto.setStreamName(student.getStreamName());

    List<PaperRequestDTO> paperDTOs =
        student.getPapers() != null
            ? student.getPapers().stream().map(this::toPaperDto).collect(Collectors.toList())
            : List.of();

    dto.setPapers(paperDTOs);

    return dto;
  }

  private PaperRequestDTO toPaperDto(Paper paper) {
    PaperRequestDTO dto = new PaperRequestDTO();
    dto.setId(paper.getId());
    dto.setAbrev(paper.getAbrev());
    dto.setPaperName(paper.getPaperName());

    // Map marks list
    List<MarksDTO> marksDTOs =
        paper.getMarks() != null
            ? paper.getMarks().stream().map(this::toMarksDTO).collect(Collectors.toList())
            : List.of();
    dto.setMarks(marksDTOs);

    return dto;
  }

  private MarksDTO toMarksDTO(Marks marks) {
    MarksDTO dto = new MarksDTO();
    dto.setId(marks.getId());
    dto.setMark(marks.getMark());
    dto.setMarkedBy(marks.getMarkedBy());
    dto.setPaperCode(marks.getPaperCode());
    dto.setPaperName(marks.getPaperName());
    dto.setGrade(marks.getGrade());
    dto.setRemark(marks.getRemark());
    return dto;
  }
}
