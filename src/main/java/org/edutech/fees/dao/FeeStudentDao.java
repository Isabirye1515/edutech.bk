package org.edutech.fees.dao;

import org.edutech.fees.valueholder.FeeStudent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FeeStudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(FeeStudent feeStudent) {
        entityManager.persist(feeStudent);
    }

    public void update(FeeStudent feeStudent) {
        entityManager.merge(feeStudent);
    }

    public void delete(int id) {
        FeeStudent feeStudent = entityManager.find(FeeStudent.class, id);
        if (feeStudent != null) {
            entityManager.remove(feeStudent);
        }
    }

    public FeeStudent getById(int id) {
        return entityManager.find(FeeStudent.class, id);
    }

    public List<FeeStudent> getAll() {
        return entityManager.createQuery("FROM FeeStudent", FeeStudent.class).getResultList();
    }
}
