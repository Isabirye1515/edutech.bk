package org.edutech.attendance.daos;

import org.edutech.attendance.AttendanceStream;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class AttendanceStreamDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addAttendanceStream(AttendanceStream stream) {
        if (stream != null) {
            entityManager.persist(stream);
        }
    }

    @Transactional
    public List<AttendanceStream> getAllStreams() {
        String jpql = "SELECT s FROM AttendanceStream s";
        return entityManager.createQuery(jpql, AttendanceStream.class).getResultList();
    }

    @Transactional
    public AttendanceStream getStreamById(int id) {
        return entityManager.find(AttendanceStream.class, id);
    }

    @Transactional
    public void updateStream(AttendanceStream stream) {
        if (stream != null && stream.getId() != 0) {
            entityManager.merge(stream);
        }
    }

    @Transactional
    public void deleteStreamById(int id) {
        AttendanceStream stream = entityManager.find(AttendanceStream.class, id);
        if (stream != null) {
            entityManager.remove(stream);
        }
    }

    @Transactional
    public void deleteAllStreams() {
        String jpql = "DELETE FROM AttendanceStream";
        entityManager.createQuery(jpql).executeUpdate();
    }

    // ✅ JPQL JOIN FETCH: Get all streams with students and their presents
    @Transactional
    public List<AttendanceStream> getAllWithStudentsAndPresents() {
        String jpql = """
            SELECT DISTINCT s
            FROM AttendanceStream s
            LEFT JOIN FETCH s.attendanceStudents st
            LEFT JOIN FETCH st.presents
        """;
        return entityManager.createQuery(jpql, AttendanceStream.class).getResultList();
    }

    // ✅ JPQL JOIN FETCH: Get one stream with students and their presents
    @Transactional
    public AttendanceStream getByIdWithStudentsAndPresents(int id) {
        String jpql = """
            SELECT DISTINCT s
            FROM AttendanceStream s
            LEFT JOIN FETCH s.attendanceStudents st
            LEFT JOIN FETCH st.presents
            WHERE s.id = :id
        """;
        return entityManager.createQuery(jpql, AttendanceStream.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
