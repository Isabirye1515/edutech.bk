package org.edutech.exams.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.edutech.exams.dao.ExamDa;
import org.edutech.exams.valueholders.Exam;
import org.edutech.exams.valueholders.dto.ExamDTO;
import org.edutech.exams.valueholders.dto.ExamStudentDTO;
import org.edutech.exams.valueholders.dto.MarksDTO;
import org.edutech.exams.valueholders.dto.PaperRequestDTO;
import org.edutech.exams.valueholders.dto.SuperVisorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExamService {

  @Autowired private ExamDa examDa;

  public void saveExam(Exam exam) {
    examDa.saveExam(exam);
  }

  public void updateExam(Exam exam) {
    examDa.updateExam(exam);
  }

  public void deleteExam(int id) {
    examDa.deleteExam(id);
  }

  public ExamDTO getExamById(int id) {
    Exam exam = examDa.getExamById(id);
    return toDTO(exam);
  }

  public List<ExamDTO> getAllExams() {
    return examDa.getAllExams().stream().map(this::toDTO).collect(Collectors.toList());
  }

  // ---------------
  // Helper: DTO Map
  // ---------------
  private ExamDTO toDTO(Exam exam) {
    ExamDTO dto = new ExamDTO();
    dto.setId(exam.getId());
    dto.setTitle(exam.getTitle());
    dto.setBeginOn(exam.getBeginOn());
    dto.setEndOn(exam.getEndOn());

    // Map supervisors
    List<SuperVisorDTO> supervisorDTOs =
        exam.getSupervisors() != null
            ? exam.getSupervisors().stream()
                .map(
                    s -> {
                      SuperVisorDTO sdto = new SuperVisorDTO();
                      sdto.setId(s.getId());
                      sdto.setPaperName(s.getPaperName());
                      sdto.setVisorName(s.getVisorName());
                      sdto.setStartAt(s.getStartAt());
                      sdto.setEndAt(s.getEndAt());
                      sdto.setDay(s.getDay());
                      sdto.setExamId(exam.getId());
                      return sdto;
                    })
                .collect(Collectors.toList())
            : List.of();
    dto.setSupervisors(supervisorDTOs);

    // Map exam students
    List<ExamStudentDTO> examStudentDTOs =
        exam.getExamStudents() != null
            ? exam.getExamStudents().stream()
                .map(
                    examS -> {
                      ExamStudentDTO examStudentDTO = new ExamStudentDTO();
                      examStudentDTO.setId(examS.getId());
                      examStudentDTO.setStudentName(examS.getStudentName());
                      examStudentDTO.setStreamName(examS.getStreamName());
                      examStudentDTO.setExamId(exam.getId());

                      // Map papers and inside marks
                      List<PaperRequestDTO> paperDTOs =
                          examS.getPapers() != null
                              ? examS.getPapers().stream()
                                  .map(
                                      paper -> {
                                        PaperRequestDTO paperDTO = new PaperRequestDTO();
                                        paperDTO.setId(paper.getId());
                                        paperDTO.setAbrev(paper.getAbrev());
                                        paperDTO.setPaperName(paper.getPaperName());
                                        paperDTO.setExamStudentId(examS.getId());

                                        List<MarksDTO> marksDTOs =
                                            paper.getMarks() != null
                                                ? paper.getMarks().stream()
                                                    .map(
                                                        mark -> {
                                                          MarksDTO marksDTO = new MarksDTO();
                                                          marksDTO.setId(mark.getId());
                                                          marksDTO.setPaperName(
                                                              mark.getPaperName());
                                                          marksDTO.setMarkedBy(mark.getMarkedBy());
                                                          marksDTO.setPaperCode(
                                                              mark.getPaperCode());
                                                          marksDTO.setMark(mark.getMark());
                                                          marksDTO.setGrade(mark.getGrade());
                                                          marksDTO.setRemark(mark.getRemark());
                                                          return marksDTO;
                                                        })
                                                    .collect(Collectors.toList())
                                                : List.of();

                                        paperDTO.setMarks(marksDTOs);
                                        return paperDTO;
                                      })
                                  .collect(Collectors.toList())
                              : List.of();

                      examStudentDTO.setPapers(paperDTOs);
                      return examStudentDTO;
                    })
                .collect(Collectors.toList())
            : List.of();

    dto.setExamStudents(examStudentDTOs);

    return dto;
  }
}
