package org.edutech.vistor.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.vistor.Vistor;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorDao {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void save(Vistor visitor) {
    entityManager.persist(visitor);
  }

  @Transactional
  public Vistor findById(int id) {
    return entityManager
        .createQuery(
            "SELECT DISTINCT v FROM Vistor v "
                + "LEFT JOIN FETCH v.contact c "
                + "LEFT JOIN FETCH c.emails "
                + "LEFT JOIN FETCH c.contact_numbers "
                + "LEFT JOIN FETCH v.visitType vt "
                + "LEFT JOIN FETCH vt.targets "
                + "WHERE v.id = :id",
            Vistor.class)
        .setParameter("id", id)
        .getSingleResult();
  }

  @Transactional
  public List<Vistor> findAll() {
    return entityManager
        .createQuery(
            "SELECT DISTINCT v FROM Vistor v "
                + "LEFT JOIN FETCH v.contact c "
                + "LEFT JOIN FETCH c.emails "
                + "LEFT JOIN FETCH c.contact_numbers "
                + "LEFT JOIN FETCH v.visitType vt "
                + "LEFT JOIN FETCH vt.targets",
            Vistor.class)
        .getResultList();
  }

  @Transactional
  public void update(Vistor visitor) {
    entityManager.merge(visitor);
  }

  @Transactional
  public void delete(int id) {
    Vistor visitor = findById(id);
    if (visitor != null) {
      entityManager.remove(visitor);
    }
  }
}
