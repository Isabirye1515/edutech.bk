package org.edutech.attendance.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.edutech.attendance.Present;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PresentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addPresent(Present present) {
        if (present != null) {
            entityManager.persist(present);
        }
    }

    @Transactional
    public List<Present> getAllPresent() {
        String jpql = "SELECT p FROM Present p ";
        List<Present> presents = entityManager.createQuery(jpql, Present.class).getResultList();
        return  presents;
    }

    @Transactional
    public Present getPresentById(int id) {
        String jpql = "SELECT p FROM Present p  WHERE p.id = :id";
        Present present = entityManager.createQuery(jpql, Present.class)
                .setParameter("id", id)
                .getSingleResult();
        return present;
    }

    @Transactional
    public void deleteAll() {
        String sql = "DELETE FROM Present";
        entityManager.createQuery(sql).executeUpdate();
    }

    @Transactional
    public void deleteById(int id) {
        Present present = entityManager.find(Present.class, id);
        if (present != null) {
            entityManager.remove(present);
        }
    }

    @Transactional
    public void updatePresent(Present present) {
        if (present != null && present.getId() != 0) {
            entityManager.merge(present);
        }
    }

    
}
