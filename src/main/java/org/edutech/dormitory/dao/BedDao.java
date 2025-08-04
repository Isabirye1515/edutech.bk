package org.edutech.dormitory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.edutech.dormitory.valueholders.Bed;
import org.springframework.stereotype.Repository;

@Repository
public class BedDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void addBed(Bed bed) {
        if (bed != null) {
            entityManager.persist(bed);
        }
    }

    @Transactional
    public List<Bed> getAllBeds() {
        String sql = "SELECT b FROM Bed b";
        return entityManager.createQuery(sql, Bed.class)
                            .getResultList();
    }

    @Transactional
    public Bed getBedById(int id) {
        String sql = "SELECT b FROM Bed b WHERE b.id = :id";
        return entityManager.createQuery(sql, Bed.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

    @Transactional
    public void deleteBed(int id) {
        Bed bed = getBedById(id);
        if (bed != null) {
            entityManager.remove(bed);
        }
    }

    @Transactional
    public void updateBed(Bed bed) {
        if (bed != null) {
            entityManager.merge(bed);
        }
    }
}
