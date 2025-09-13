package org.edutech.exams.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.exams.valueholders.Paper;
import org.springframework.stereotype.Repository;

@Repository
public class PaperDao {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void save(Paper paper) {
    entityManager.persist(paper);
  }

  @Transactional
  public void update(Paper paper) {
    entityManager.merge(paper);
  }

  @Transactional
  public void deleteById(int id) {
    Paper paper = entityManager.find(Paper.class, id);
    if (paper != null) {
      entityManager.remove(paper);
    }
  }

  public Paper findById(int id) {
    List<Paper> result =
        entityManager
            .createQuery(
                "SELECT DISTINCT p FROM Paper p " + "LEFT JOIN FETCH p.marks " + "WHERE p.id = :id",
                Paper.class)
            .setParameter("id", id)
            .getResultList();

    return result.isEmpty() ? null : result.get(0);
  }

  public List<Paper> findAll() {
    return entityManager
        .createQuery("SELECT DISTINCT p FROM Paper p " + "LEFT JOIN FETCH p.marks", Paper.class)
        .getResultList();
  }
}
