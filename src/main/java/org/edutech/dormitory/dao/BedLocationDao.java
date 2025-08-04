package org.edutech.dormitory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.edutech.dormitory.valueholders.BedLocation;
import org.springframework.stereotype.Repository;

@Repository
public class BedLocationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addLocation(BedLocation location) {
        if (location != null) {
            entityManager.persist(location);
        }
    }

    @Transactional
    public List<BedLocation> getAllLocations() {
        return entityManager.createQuery("SELECT l FROM BedLocation l", BedLocation.class)
                            .getResultList();
    }

    @Transactional
    public BedLocation getLocationById(int id) {
        return entityManager.createQuery("SELECT l FROM BedLocation l WHERE l.id = :id", BedLocation.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

    @Transactional
    public void deleteLocation(int id) {
        BedLocation location = getLocationById(id);
        if (location != null) {
            entityManager.remove(location);
        }
    }

    @Transactional
    public void updateLocation(BedLocation location) {
        if (location != null) {
            entityManager.merge(location);
        }
    }
}
