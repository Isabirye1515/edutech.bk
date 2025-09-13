package org.edutech.Student.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.Student.valueholder.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void addStudent(Student student) {
    if (student != null) {
      entityManager.persist(student);
    }
  }

  @Transactional
  public List<Student> getAllStudents() {
    return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
  }

  @Transactional
  public Student getStudentById(int id) {
    return entityManager
        .createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  @Transactional
  public void deleteStudent(int id) {
    Student student = getStudentById(id);
    if (student != null) {
      entityManager.remove(student);
    }
  }

  @Transactional
  public void updateStudent(Student student) {
    if (student != null) {
      entityManager.merge(student);
    }
  }
}
