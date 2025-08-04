package org.edutech.parent.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.edutech.parent.valueholder.Parent;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class  ParentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveParent(Parent parent) {
        entityManager.persist(parent);
    }

    @Transactional
    public Parent getParentById(int id) {
        return entityManager.find(Parent.class, id);
    }

    @Transactional
    public void updateParent(Parent parent) {
        entityManager.merge(parent);
    }

    @Transactional
    public void deleteParent(int id) {
        Parent parent = entityManager.find(Parent.class, id);
        if (parent != null) {
            entityManager.remove(parent);
        }
    }

    @Transactional
    public List<Parent> getAllParents() {
        return entityManager.createQuery("FROM Parent", Parent.class).getResultList();
    }
}
