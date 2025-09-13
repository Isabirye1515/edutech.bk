package org.edutech.exams.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.exams.valueholders.Ranges;
import org.springframework.stereotype.Repository;

@Repository
public class RangesDao {

  @PersistenceContext private EntityManager entityManager;

  public Ranges findById(int id) {
    return entityManager.find(Ranges.class, id);
  }

  public List<Ranges> findAll() {
    return entityManager.createQuery("FROM Ranges", Ranges.class).getResultList();
  }

  @Transactional
  public void save(Ranges ranges) {
    entityManager.persist(ranges);
  }

  @Transactional
  public void update(Ranges ranges) {
    entityManager.merge(ranges);
  }

  @Transactional
  public void deleteById(int id) {
    Ranges range = entityManager.find(Ranges.class, id);
    if (range != null) {
      entityManager.remove(range);
    }
  }
}
