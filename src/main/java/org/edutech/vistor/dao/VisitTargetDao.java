package org.edutech.vistor.dao;

import org.edutech.vistor.VisitTarget;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class VisitTargetDao {

    @PersistenceContext
    private EntityManager entityManager;

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
