package org.edutech.timetable.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.timetable.DayTimeTable;
import org.springframework.stereotype.Repository;

@Repository
public class DayTimeTableDao {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void saveDayTimeTable(DayTimeTable dayTimeTable) {
    entityManager.persist(dayTimeTable);
  }

  @Transactional
  public DayTimeTable getDayTimeTableById(int id) {
    return entityManager.find(DayTimeTable.class, id);
  }

  @Transactional
  public void updateDayTimeTable(DayTimeTable dayTimeTable) {
    entityManager.merge(dayTimeTable);
  }

  @Transactional
  public void deleteDayTimeTable(int id) {
    DayTimeTable dayTimeTable = entityManager.find(DayTimeTable.class, id);
    if (dayTimeTable != null) {
      entityManager.remove(dayTimeTable);
    }
  }

  @Transactional
  public void deleteAllDayTimeTables() {
    entityManager.createQuery("DELETE FROM DayTimeTable").executeUpdate();
  }

  @Transactional
  public DayTimeTable getDayTimeTableByDay(String day) {
    try {
      return entityManager
          .createQuery("SELECT dtt FROM DayTimeTable dtt WHERE dtt.day = :day", DayTimeTable.class)
          .setParameter("day", day)
          .getSingleResult();
    } catch (Exception e) {
      return null; // or handle the exception as needed
    }
  }

  @Transactional
  public List<DayTimeTable> getAllDayTimeTables() {
    return entityManager
        .createQuery("SELECT dtt FROM DayTimeTable dtt", DayTimeTable.class)
        .getResultList();
  }
}
