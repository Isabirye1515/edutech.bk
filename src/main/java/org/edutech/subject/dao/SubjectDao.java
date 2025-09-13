package org.edutech.subject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.subject.valueholder.Subject;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDao {
  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void saveSubject(Subject subject) {
    entityManager.persist(subject);
  }

  @Transactional
  public Subject getSubjectById(int id) {
    return entityManager.find(Subject.class, id);
  }

  @Transactional
  public void updateSubject(Subject subject) {
    entityManager.merge(subject);
  }

  @Transactional
  public void deleteSubject(int id) {
    Subject subject = entityManager.find(Subject.class, id);
    if (subject != null) {
      entityManager.remove(subject);
    }
  }

  @Transactional
  public void deleteAllSubjects() {
    entityManager.createQuery("DELETE FROM Subject").executeUpdate();
  }

  @Transactional
  public Subject getSubjectByName(String name) {
    try {
      return entityManager
          .createQuery("SELECT s FROM Subject s WHERE s.name = :name", Subject.class)
          .setParameter("name", name)
          .getSingleResult();
    } catch (Exception e) {
      return null; // or handle the exception as needed
    }
  }

  @Transactional
  public List<Subject> getAllSubjects() {
    return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
  }
}
