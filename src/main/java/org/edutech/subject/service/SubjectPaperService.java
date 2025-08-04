package org.edutech.subject.service;

import java.util.List;

import org.edutech.subject.dao.SubjectPaperDao;
import org.edutech.subject.valueholder.SubjectPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectPaperService {

    @Autowired
    private SubjectPaperDao subjectPaperDao;

    public void addSubjectPaper(SubjectPaper subjectPaper) {
        subjectPaperDao.addSubjectPaper(subjectPaper);
    }

    public SubjectPaper getSubjectPaperById(int id) {
        return subjectPaperDao.getsSubjectPaperById(id);
    }

    public List<SubjectPaper> getAllSubjectPapers() {
        return subjectPaperDao.getAllSubjectPapers();
    }

    public void updateSubjectPaper(SubjectPaper subjectPaper) {
        subjectPaperDao.updateSubjectPaper(subjectPaper);
    }

    public void deleteSubjectPaperById(int id) {
        subjectPaperDao.deleteById(id);
    }

    public void deleteAllSubjectPapers() {
        subjectPaperDao.deleteAll();
    }
}
