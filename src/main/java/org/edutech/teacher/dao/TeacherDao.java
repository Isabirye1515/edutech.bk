package org.edutech.teacher.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.teacher.valueholders.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao {
  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void saveTeacher(Teacher teacher) {
    entityManager.persist(teacher);
  }

  @Transactional
  public List<Teacher> getAllTeachers() {
    return entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
  }

  @Transactional
  public Teacher getTeacherById(int id) {
    return entityManager.find(Teacher.class, id);
  }

  @Transactional
  public void updateTeacher(Teacher teacher) {
    entityManager.merge(teacher);
  }

  @Transactional
  public void deleteTeacher(int id) {
    Teacher teacher = entityManager.find(Teacher.class, id);
    if (teacher != null) {
      entityManager.remove(teacher);
    }
  }

  @Transactional
  public void deleteAllTeachers() {
    entityManager.createQuery("DELETE FROM Teacher").executeUpdate();
  }

  @Transactional
  public Teacher getTeacherByName(String name) {
    try {
      return entityManager
          .createQuery("SELECT t FROM Teacher t WHERE t.name = :name", Teacher.class)
          .setParameter("name", name)
          .getSingleResult();
    } catch (Exception e) {
      return null; // or handle the exception as needed
    }
  }
}
