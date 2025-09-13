package org.edutech.vistor.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.vistor.VisitTarget;
import org.springframework.stereotype.Repository;

@Repository
public class VisitTargetDao {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void save(VisitTarget visitTarget) {
    entityManager.persist(visitTarget);
  }

  @Transactional
  public VisitTarget findById(int id) {
    return entityManager.find(VisitTarget.class, id);
  }

  @Transactional
  public List<VisitTarget> findAll() {
    return entityManager.createQuery("FROM VisitTarget", VisitTarget.class).getResultList();
  }

  @Transactional
  public void update(VisitTarget visitTarget) {
    entityManager.merge(visitTarget);
  }

  @Transactional
  public void delete(int id) {
    VisitTarget visitTarget = findById(id);
    if (visitTarget != null) entityManager.remove(visitTarget);
  }
}
