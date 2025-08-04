package org.edutech.Student.dao;

import org.edutech.Student.valueholder.Club;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClubDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public void addClub(Club club) {
        if (club != null) {
            entityManager.persist(club);
        }
    }

    @Transactional
    public List<Club> getAllClubs() {
        return entityManager.createQuery("SELECT c FROM Club c", Club.class).getResultList();
    }

    @Transactional
    public Club getClubById(int id) {
        return entityManager.createQuery("SELECT c FROM Club c WHERE c.id = :id", Club.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public void deleteClub(int id) {
        Club club = getClubById(id);
        if (club != null) {
            entityManager.remove(club);
        }
    }

    @Transactional
    public void updateClub(Club club) {
        if (club != null) {
            entityManager.merge(club);
        }
    }
}
