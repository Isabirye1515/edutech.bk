package org.edutech.vistor.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.vistor.VisitType;
import org.springframework.stereotype.Repository;

@Repository
public class VisitTypeDao {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void save(VisitType visitType) {
    entityManager.persist(visitType);
  }

  @Transactional
  public VisitType findById(int id) {
    return entityManager
        .createQuery(
            "SELECT vt FROM VisitType vt LEFT JOIN FETCH vt.targets WHERE vt.id = :id",
            VisitType.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  @Transactional
  public List<VisitType> findAll() {
    return entityManager
        .createQuery(
            "SELECT DISTINCT vt FROM VisitType vt LEFT JOIN FETCH vt.targets", VisitType.class)
        .getResultList();
  }

  @Transactional
  public void update(VisitType visitType) {
    entityManager.merge(visitType);
  }

  @Transactional
  public void delete(int id) {
    VisitType visitType = findById(id);
    if (visitType != null) entityManager.remove(visitType);
  }
}
