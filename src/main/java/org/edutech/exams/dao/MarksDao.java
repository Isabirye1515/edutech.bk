package org.edutech.exams.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.exams.valueholders.Marks;
import org.springframework.stereotype.Repository;

@Repository
public class MarksDao {

  @PersistenceContext private EntityManager entityManager;

  public List<Marks> findAll() {
    return entityManager.createQuery("SELECT m FROM Marks m", Marks.class).getResultList();
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
    return entityManager
        .createQuery("SELECT m FROM Marks m WHERE m.examStudent.id = :examStudentId", Marks.class)
        .setParameter("examStudentId", examStudentId)
        .getResultList();
  }
}
