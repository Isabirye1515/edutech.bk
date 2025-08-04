package org.edutech.exams.service;


import org.edutech.exams.dao.ExamDa;
import org.edutech.exams.dao.SuperVisorDao;
import org.edutech.exams.valueholders.SuperVisor;
import org.edutech.exams.valueholders.dto.SuperVisorDTO;
import org.edutech.exams.valueholders.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SuperVisorService {

    @Autowired
    private SuperVisorDao superVisorDa;

    @Autowired
    private ExamDa examDa;

    public void addSuperVisor(SuperVisor supervisor) {
        if (supervisor.getExam() != null && supervisor.getExam().getId() > 0) {
            Exam exam = examDa.getExamById(supervisor.getExam().getId());
            supervisor.setExam(exam);
        } else {
            supervisor.setExam(null);
        }

        superVisorDa.saveSuperVisor(supervisor);
    }

    public void updateSuperVisor(SuperVisor supervisor) {
        superVisorDa.updateSuperVisor(supervisor);
    }

    public void deleteSuperVisor(int id) {
        superVisorDa.deleteSuperVisor(id);
    }

    public SuperVisorDTO getSuperVisorById(int id) {
        SuperVisor s = superVisorDa.getSuperVisorById(id);
        return toDTO(s);
    }

    public List<SuperVisorDTO> getAllSuperVisors() {
        return superVisorDa.getAllSuperVisors()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private SuperVisorDTO toDTO(SuperVisor s) {
        SuperVisorDTO dto = new SuperVisorDTO();
        dto.setId(s.getId());
        dto.setPaperName(s.getPaperName());
        dto.setVisorName(s.getVisorName());
        dto.setStartAt(s.getStartAt());
        dto.setEndAt(s.getEndAt());
        dto.setDay(s.getDay());
        dto.setExamId(s.getExam() != null ? s.getExam().getId() : 0);
        return dto;
    }
}
