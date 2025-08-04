package org.edutech.timetable.dao;

import org.edutech.timetable.TableStream;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TableStreamDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(TableStream tableStream) {
        entityManager.persist(tableStream);
    }

    @Transactional
    public TableStream findById(int id) {
        return entityManager.find(TableStream.class, id);
    }

    @Transactional
    public List<TableStream> findAll() {
        return entityManager.createQuery("SELECT t FROM TableStream t", TableStream.class)
                            .getResultList();
    }

    @Transactional
    public void delete(int id) {
        TableStream ts = entityManager.find(TableStream.class, id);
        if (ts != null) {
            entityManager.remove(ts);
        }
    }

    @Transactional
    public TableStream update(TableStream tableStream) {
        return entityManager.merge(tableStream);
    }
}
