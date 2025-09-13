package org.edutech.fees.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.fees.valueholder.PaidAmount;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PaidAmountDao {

  @PersistenceContext private EntityManager entityManager;

  public void save(PaidAmount paidAmount) {
    entityManager.persist(paidAmount);
  }

  public void update(PaidAmount paidAmount) {
    entityManager.merge(paidAmount);
  }

  public void delete(int id) {
    PaidAmount paidAmount = entityManager.find(PaidAmount.class, id);
    if (paidAmount != null) {
      entityManager.remove(paidAmount);
    }
  }

  public PaidAmount getById(int id) {
    return entityManager.find(PaidAmount.class, id);
  }

  public List<PaidAmount> getAll() {
    return entityManager.createQuery("FROM PaidAmount", PaidAmount.class).getResultList();
  }
}
