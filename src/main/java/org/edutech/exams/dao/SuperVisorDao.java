package org.edutech.exams.dao;

import org.edutech.exams.valueholders.SuperVisor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class SuperVisorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveSuperVisor(SuperVisor supervisor) {
        entityManager.persist(supervisor);
    }

    @Transactional
    public void updateSuperVisor(SuperVisor supervisor) {
        entityManager.merge(supervisor);
    }

    @Transactional
    public void deleteSuperVisor(int id) {
        SuperVisor supervisor = getSuperVisorById(id);
        if (supervisor != null) {
            entityManager.remove(supervisor);
        }
    }

    @Transactional
    public SuperVisor getSuperVisorById(int id) {
        return entityManager.find(SuperVisor.class, id);
    }

    @Transactional
    public List<SuperVisor> getAllSuperVisors() {
        return entityManager.createQuery("FROM SuperVisor", SuperVisor.class).getResultList();
    }
}
