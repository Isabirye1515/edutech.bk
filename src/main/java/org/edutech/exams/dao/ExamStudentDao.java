package org.edutech.exams.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.exams.valueholders.ExamStudent;
import org.springframework.stereotype.Repository;

@Repository
public class ExamStudentDao {

  @PersistenceContext private EntityManager entityManager;

  public List<ExamStudent> findAll() {
    return entityManager
        .createQuery(
            "SELECT DISTINCT es FROM ExamStudent es "
                + "LEFT JOIN FETCH es.papers p "
                + "LEFT JOIN FETCH p.marks ",
            ExamStudent.class)
        .getResultList();
  }

  public ExamStudent findById(int id) {
    List<ExamStudent> result =
        entityManager
            .createQuery(
                "SELECT DISTINCT es FROM ExamStudent es "
                    + "LEFT JOIN FETCH es.papers p "
                    + "LEFT JOIN FETCH p.marks "
                    + "WHERE es.id = :id",
                ExamStudent.class)
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
