package org.edutech.timetable.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.edutech.timetable.WeekendTimeTable;
import org.springframework.stereotype.Repository;
@Repository
public class WeekendTimeTableDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveWeekendTimeTable(WeekendTimeTable weekendTimeTable) {
        entityManager.persist(weekendTimeTable);
    
    }
    @Transactional
    public WeekendTimeTable getWeekendTimeTableById(int id) {
        return entityManager.find(WeekendTimeTable.class, id);
    }
    @Transactional
    public void updateWeekendTimeTable(WeekendTimeTable weekendTimeTable) {
        entityManager.merge(weekendTimeTable);
    }
    @Transactional
    public void deleteWeekendTimeTable(int id) {
        WeekendTimeTable weekendTimeTable = entityManager.find(WeekendTimeTable.class, id);
        if (weekendTimeTable != null) {
            entityManager.remove(weekendTimeTable);
        }
    }
    @Transactional
    public void deleteAllWeekendTimeTables() {
        entityManager.createQuery("DELETE FROM WeekendTimeTable").executeUpdate();
    }
    @Transactional
    public WeekendTimeTable getWeekendTimeTableByDay(String day) {
        try {
            return entityManager.createQuery("SELECT wtt FROM WeekendTimeTable wtt WHERE wtt.day = :day", WeekendTimeTable.class)
                .setParameter("day", day)
                .getSingleResult();
        } catch (Exception e) {
            return null; // or handle the exception as needed
        }
    }
    @Transactional
    public List<WeekendTimeTable> getAllWeekendTimeTables() {
        return entityManager.createQuery("SELECT wtt FROM WeekendTimeTable wtt", WeekendTimeTable.class).getResultList();
    }
    
    
}
