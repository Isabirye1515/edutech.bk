package org.edutech.exams.dao;

import org.edutech.exams.valueholders.ExamStudent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ExamStudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ExamStudent> findAll() {
        return entityManager.createQuery(
            "SELECT DISTINCT es FROM ExamStudent es " +
            "LEFT JOIN FETCH es.papers p " +
            "LEFT JOIN FETCH p.marks ", ExamStudent.class)
            .getResultList();
    }

    public ExamStudent findById(int id) {
        List<ExamStudent> result = entityManager.createQuery(
            "SELECT DISTINCT es FROM ExamStudent es " +
            "LEFT JOIN FETCH es.papers p " +
            "LEFT JOIN FETCH p.marks " +
            "WHERE es.id = :id", ExamStudent.class)
            .setParameter("id", id)
            .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    @Transactional
    public void save(ExamStudent examStudent) {
        entityManager.persist(examStudent);
    }

    @Transactional
    public ExamStudent update(ExamStudent examStudent) {
        return entityManager.merge(examStudent);
    }

    @Transactional
    public void deleteById(int id) {
        ExamStudent examStudent = findById(id);
        if (examStudent != null) {
            entityManager.remove(examStudent);
        }
    }
}
