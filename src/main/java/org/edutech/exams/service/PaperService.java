package org.edutech.exams.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.edutech.exams.dao.PaperDao;
import org.edutech.exams.valueholders.Marks;
import org.edutech.exams.valueholders.Paper;
import org.edutech.exams.valueholders.dto.MarksDTO;
import org.edutech.exams.valueholders.dto.PaperRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperService {

  @Autowired private PaperDao paperDao;

  // Get all papers - returns DTO list
  public List<PaperRequestDTO> getAllPapers() {
    return paperDao.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
  }

  // Get paper by id - returns DTO
  public PaperRequestDTO getPaperById(int id) {
    Paper paper = paperDao.findById(id);
    if (paper == null) throw new RuntimeException("Paper not found");
    return toResponseDTO(paper);
  }

  // Create paper - uses entities directly (input is Paper entity)
  @Transactional
  public void createPaper(Paper paper) {
    paperDao.save(paper);
  }

  // Update paper - uses entities directly (input is Paper entity)
  @Transactional
  public void updatePaper(Paper paper) {
    Paper existing = paperDao.findById(paper.getId());
    if (existing == null) throw new RuntimeException("Paper not found");

    existing.setAbrev(paper.getAbrev());
    existing.setPaperName(paper.getPaperName());
    paperDao.update(existing);
  }

  // Delete paper by id
  @Transactional
  public void deletePaper(int id) {
    Paper paper = paperDao.findById(id);
    if (paper == null) throw new RuntimeException("Paper not found");
    paperDao.deleteById(id);
  }

  // Helper: map entity → DTO
  private PaperRequestDTO toResponseDTO(Paper paper) {
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
    dto.setMarkedBy(marks.getMarkedBy());
    dto.setPaperCode(marks.getPaperCode());
    dto.setMark(marks.getMark());
    dto.setPaperName(marks.getPaperName());
    dto.setGrade(marks.getGrade());
    dto.setRemark(marks.getRemark());
    return dto;
  }
}
