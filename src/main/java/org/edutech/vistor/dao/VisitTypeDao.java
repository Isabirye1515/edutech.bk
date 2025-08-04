package org.edutech.vistor.dao;


import org.edutech.vistor.VisitType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class VisitTypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(VisitType visitType) {
        entityManager.persist(visitType);
    }

    @Transactional
    public VisitType findById(int id) {
    return entityManager.createQuery(
        "SELECT vt FROM VisitType vt LEFT JOIN FETCH vt.targets WHERE vt.id = :id", VisitType.class)
        .setParameter("id", id)
        .getSingleResult();
}

    @Transactional
    public List<VisitType> findAll() {
    return entityManager.createQuery(
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
