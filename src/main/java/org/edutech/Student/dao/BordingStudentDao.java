package org.edutech.Student.dao;

import org.edutech.Student.valueholder.BordingStudent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BordingStudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addBordingStudent(BordingStudent bordingStudent) {
        if (bordingStudent != null) {
            entityManager.persist(bordingStudent);
        }
    }

    @Transactional
    public List<BordingStudent> getAllBordingStudents() {
        return entityManager.createQuery(
                "SELECT DISTINCT b FROM BordingStudent b " +
                "LEFT JOIN FETCH b.student s " +
                "LEFT JOIN FETCH s.contact c " +
                "LEFT JOIN FETCH c.emails e " +
                "LEFT JOIN FETCH c.contact_numbers cn", BordingStudent.class)
            .getResultList();
    }

    @Transactional
    public BordingStudent getBordingStudentById(int id) {
        List<BordingStudent> results = entityManager.createQuery(
                "SELECT b FROM BordingStudent b " +
                "LEFT JOIN FETCH b.student s " +
                "LEFT JOIN FETCH s.contact c " +
                "LEFT JOIN FETCH c.emails e " +
                "LEFT JOIN FETCH c.contact_numbers cn " +
                "WHERE b.id = :id", BordingStudent.class)
            .setParameter("id", id)
            .getResultList();

        return results.isEmpty() ? null : results.get(0);
    }

    @Transactional
    public void deleteBordingStudent(int id) {
        BordingStudent student = getBordingStudentById(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Transactional
    public void updateBordingStudent(BordingStudent bordingStudent) {
        if (bordingStudent != null) {
            entityManager.merge(bordingStudent);
        }
    }
}
