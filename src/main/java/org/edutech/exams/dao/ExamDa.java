package org.edutech.exams.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.exams.valueholders.Exam;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDa {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void saveExam(Exam exam) {
    entityManager.persist(exam);
  }

  @Transactional
  public void updateExam(Exam exam) {
    entityManager.merge(exam);
  }

  @Transactional
  public void deleteExam(int id) {
    Exam exam = getExamById(id);
    if (exam != null) {
      entityManager.remove(exam);
    }
  }

  @Transactional
  public Exam getExamById(int id) {
    List<Exam> result =
        entityManager
            .createQuery(
                "SELECT DISTINCT e FROM Exam e "
                    + "LEFT JOIN FETCH e.examStudents es "
                    + "LEFT JOIN FETCH es.papers p "
                    + "LEFT JOIN FETCH p.marks m "
                    + "LEFT JOIN FETCH e.supervisors s "
                    + "WHERE e.id = :id",
                Exam.class)
            .setParameter("id", id)
            .getResultList();
    return result.isEmpty() ? null : result.get(0);
  }

  @Transactional
  public List<Exam> getAllExams() {
    return entityManager
        .createQuery(
            "SELECT DISTINCT e FROM Exam e "
                + "LEFT JOIN FETCH e.examStudents es "
                + "LEFT JOIN FETCH es.papers p "
                + "LEFT JOIN FETCH p.marks m "
                + "LEFT JOIN FETCH e.supervisors s",
            Exam.class)
        .getResultList();
  }
}
