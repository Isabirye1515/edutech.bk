package org.edutech.subject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.edutech.subject.dao.SubjectDao;

import org.edutech.subject.valueholder.Subject;
import org.edutech.subject.valueholder.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    
    @Autowired
    private SubjectDao subjectDao;

    public void saveSubject(Subject subject) {
        subjectDao.saveSubject(subject);
    }

       public Subject getSubjectById(int id) {
        Subject subject = subjectDao.getSubjectById(id);
        return subject ;
    }

    public SubjectDTO getSubjectDTOById(int id) {
        Subject subject = subjectDao.getSubjectById(id);
        return subject != null ? convertToDTO(subject) : null;
    }

    public void updateSubject(Subject subject) {
        subjectDao.updateSubject(subject);
    }

    public void deleteSubject(int id) {
        subjectDao.deleteSubject(id);
    }

    public void deleteAllSubjects() {
        subjectDao.deleteAllSubjects();
    }

    public Subject getSubjectByName(String name) {
        return subjectDao.getSubjectByName(name);
    }

    public List<SubjectDTO> getAllSubjects() {
        return subjectDao.getAllSubjects().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private SubjectDTO convertToDTO(Subject subject) {
        SubjectDTO dto = new SubjectDTO();
        dto.setId(subject.getId());
        dto.setUuid(subject.getUuid());
        dto.setSubjectName(subject.getSubjectName());
        dto.setDescription(subject.getDescription());
        dto.setTeacherId(subject.getTeacher().getId());
        return dto;
    }
}
