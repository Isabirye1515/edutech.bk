package org.edutech.attendance.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.edutech.attendance.AttendanceStudent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AttendanceStudentDao {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void addAttendanceStudent(AttendanceStudent student) {
    if (student != null) {
      entityManager.persist(student);
    }
  }

  @Transactional
  public void deleteAllAttendanceStudents() {
    String jpql = "DELETE FROM AttendanceStudent";
    entityManager.createQuery(jpql).executeUpdate();
  }

  @Transactional
  public void deleteAttendanceStudentById(int id) {
    AttendanceStudent student = entityManager.find(AttendanceStudent.class, id);
    if (student != null) {
      entityManager.remove(student);
    }
  }

  @Transactional
  public void updateAttendanceStudent(AttendanceStudent student) {
    if (student != null && student.getId() != 0) {
      entityManager.merge(student);
    }
  }

  // ✅ JPQL Method: Find by School ID
  @Transactional
  public List<AttendanceStudent> findBySchoolId(String schoolId) {
    String jpql = "SELECT a FROM AttendanceStudent a WHERE a.schoolId = :schoolId";
    return entityManager
        .createQuery(jpql, AttendanceStudent.class)
        .setParameter("schoolId", schoolId)
        .getResultList();
  }

  // ✅ JPQL Method: Find by Stream ID
  @Transactional
  public List<AttendanceStudent> findByStreamId(int streamId) {
    String jpql = "SELECT a FROM AttendanceStudent a WHERE a.attendanceStream.id = :streamId";
    return entityManager
        .createQuery(jpql, AttendanceStudent.class)
        .setParameter("streamId", streamId)
        .getResultList();
  }

  // ✅ JPQL Method: Find by Attendance Name
  @Transactional
  public List<AttendanceStudent> findByAttendanceName(String name) {
    String jpql =
        "SELECT a FROM AttendanceStudent a WHERE LOWER(a.attendanceName) LIKE LOWER(:name)";
    return entityManager
        .createQuery(jpql, AttendanceStudent.class)
        .setParameter("name", "%" + name + "%")
        .getResultList();
  }

  // ✅ JOIN FETCH: Get all AttendanceStudents with their Present records
  @Transactional
  public List<AttendanceStudent> getAllAttendanceStudents() {
    String jpql = "SELECT DISTINCT a FROM AttendanceStudent a LEFT JOIN FETCH a.presents";
    return entityManager.createQuery(jpql, AttendanceStudent.class).getResultList();
  }

  // ✅ JOIN FETCH: Get a specific AttendanceStudent with their Present records
  @Transactional
  public AttendanceStudent getAttendanceStudentById(int id) {
    String jpql = "SELECT a FROM AttendanceStudent a LEFT JOIN FETCH a.presents WHERE a.id = :id";
    return entityManager
        .createQuery(jpql, AttendanceStudent.class)
        .setParameter("id", id)
        .getSingleResult();
  }
}
