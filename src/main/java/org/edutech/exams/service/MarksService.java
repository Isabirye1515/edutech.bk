package org.edutech.exams.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.edutech.exams.dao.MarksDao;
import org.edutech.exams.valueholders.Marks;
import org.edutech.exams.valueholders.dto.MarksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarksService {

  @Autowired private MarksDao marksDao;

  public List<MarksDTO> getAllMarks() {
    return marksDao.findAll().stream().map(this::toDto).collect(Collectors.toList());
  }

  public MarksDTO getMarksById(int id) {
    Marks marks = marksDao.findById(id);
    if (marks == null) throw new RuntimeException("Marks not found");
    return toDto(marks);
  }

  @Transactional
  public void createMarks(Marks marks) {
    marksDao.save(marks);
  }

  @Transactional
  public void updateMarks(Marks marks) {
    Marks existing = marksDao.findById(marks.getId());
    if (existing == null) throw new RuntimeException("Marks not found");
    marksDao.update(marks);
  }

  @Transactional
  public void deleteMarks(int id) {
    marksDao.deleteById(id);
  }

  public List<Marks> getMarksByExamStudentId(int examStudentId) {
    return marksDao.findByExamStudentId(examStudentId);
  }

  private MarksDTO toDto(Marks marks) {
    MarksDTO dto = new MarksDTO();
    dto.setId(marks.getId());
    dto.setPaperName(marks.getPaperName());
    dto.setMark(marks.getMark());
    dto.setGrade(marks.getGrade());
    dto.setRemark(marks.getRemark());
    return dto;
  }
}
