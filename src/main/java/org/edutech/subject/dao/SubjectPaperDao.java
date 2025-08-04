package org.edutech.subject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.edutech.subject.valueholder.SubjectPaper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SubjectPaperDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addSubjectPaper(SubjectPaper subjectPaper) {
        if (subjectPaper != null) {
            entityManager.persist(subjectPaper);
        }
    }

    public SubjectPaper getsSubjectPaperById(int id) {
        return entityManager.find(SubjectPaper.class, id);
    }

    public List<SubjectPaper> getAllSubjectPapers() {
        return entityManager.createQuery("SELECT s FROM SubjectPaper s", SubjectPaper.class).getResultList();
    }

    @Transactional
    public void deleteById(int id) {
        SubjectPaper paper = entityManager.find(SubjectPaper.class, id);
        if (paper != null) {
            entityManager.remove(paper);
        }
    }

    @Transactional
    public void updateSubjectPaper(SubjectPaper paper) {
        if (paper != null) {
            entityManager.merge(paper);
        }
    }

    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM SubjectPaper").executeUpdate();
    }
}
