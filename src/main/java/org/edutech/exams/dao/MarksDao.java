package org.edutech.exams.dao;


import org.edutech.exams.valueholders.Marks;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MarksDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Marks> findAll() {
        return entityManager.createQuery("SELECT m FROM Marks m", Marks.class)
                .getResultList();
    }

    public Marks findById(int id) {
        return entityManager.find(Marks.class, id);
    }

    @Transactional
    public void save(Marks marks) {
        entityManager.persist(marks);
    }

    @Transactional
    public Marks update(Marks marks) {
        return entityManager.merge(marks);
    }

    @Transactional
    public void deleteById(int id) {
        Marks marks = findById(id);
        if (marks != null) {
            entityManager.remove(marks);
        }
    }

    // Optional: find marks by ExamStudent id
    public List<Marks> findByExamStudentId(int examStudentId) {
        return entityManager.createQuery("SELECT m FROM Marks m WHERE m.examStudent.id = :examStudentId", Marks.class)
                .setParameter("examStudentId", examStudentId)
                .getResultList();
    }
}

