package org.edutech.timetable.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.edutech.timetable.TimeProgram;
import org.springframework.stereotype.Repository;
@Repository
public class TimeProgramDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void saveTimeProgram(TimeProgram timeProgram) {
        entityManager.persist(timeProgram);
    }
    @Transactional
    public TimeProgram getTimeProgramById(int id) {
        return entityManager.find(TimeProgram.class, id);
    
    }
    @Transactional
    public void updateTimeProgram(TimeProgram timeProgram) {
        entityManager.merge(timeProgram);
    }
    @Transactional
    public void deleteTimeProgram(int id) {
        TimeProgram timeProgram = entityManager.find(TimeProgram.class, id);
        if (timeProgram != null) {
            entityManager.remove(timeProgram);
        }
    }
    @Transactional
    public void deleteAllTimePrograms() {
        entityManager.createQuery("DELETE FROM TimeProgram").executeUpdate();
    }
    @Transactional
    public void deleteTimeProgramByTitle(String title) {
        entityManager.createQuery("DELETE FROM TimeProgram tp WHERE tp.title = :title")
            .setParameter("title", title)
            .executeUpdate();
    }
    @Transactional
    public TimeProgram getTimeProgramByTitle(String title) {
        try {
            return entityManager.createQuery("SELECT tp FROM TimeProgram tp WHERE tp.title = :title", TimeProgram.class)
                .setParameter("title", title)
                .getSingleResult();
        } catch (Exception e) {
            return null; // or handle the exception as needed
        }
    }
    @Transactional
    public List<TimeProgram> getAllTimePrograms() {
        return entityManager.createQuery("SELECT tp FROM TimeProgram tp", TimeProgram.class).getResultList();
    }
}

