package org.edutech.timetable.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.edutech.timetable.PrepTimeTable;
import org.springframework.stereotype.Repository;
@Repository
public class PrepTimeTableDao {
@PersistenceContext
    private EntityManager entityManager;

@Transactional
    public void savePrepTimeTable(PrepTimeTable prepTimeTable) {
        entityManager.persist(prepTimeTable);

    }
    @Transactional
    public PrepTimeTable getPrepTimeTableById(int id) {
        return entityManager.find(PrepTimeTable.class, id);
    }
    @Transactional
    public void updatePrepTimeTable(PrepTimeTable prepTimeTable) {
        entityManager.merge(prepTimeTable);
    }

    @Transactional
    public void deletePrepTimeTable(int id) {
        PrepTimeTable prepTimeTable = entityManager.find(PrepTimeTable.class, id);
        if (prepTimeTable != null) {
            entityManager.remove(prepTimeTable);
        }
    }
    @Transactional
    public void deleteAllPrepTimeTables() {
        entityManager.createQuery("DELETE FROM PrepTimeTable").executeUpdate();
    }

    @Transactional
    public PrepTimeTable getPrepTimeTableByDay(String day) {
        try {
            return entityManager.createQuery("SELECT ptt FROM PrepTimeTable ptt WHERE ptt.day = :day", PrepTimeTable.class)
                .setParameter("day", day)
                .getSingleResult();
        } catch (Exception e) {
            return null; // or handle the exception as needed
        }
    }
    @Transactional
    public List<PrepTimeTable> getAllPrepTimeTables() {
        return entityManager.createQuery("SELECT ptt FROM PrepTimeTable ptt", PrepTimeTable.class).getResultList();
    }
    

    
    
}
