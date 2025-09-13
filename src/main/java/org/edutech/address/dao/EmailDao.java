package org.edutech.address.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.address.valuehoders.Email;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDao {
  @PersistenceContext private EntityManager entityManager;

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Transactional
  public void addEmail(Email email) {
    if (email != null) {
      entityManager.persist(email);
    }
  }

  @Transactional
  public List<Email> getAllEmails() {
    String sql = "Select e from Email e";
    List<Email> emails = entityManager.createQuery(sql, Email.class).getResultList();
    return emails;
  }

  @Transactional
  public Email getEmailById(int id) {
    String sql = "select e from Email e where e.id = :id";
    Email email =
        entityManager.createQuery(sql, Email.class).setParameter("id", id).getSingleResult();
    return email;
  }

  @Transactional
  public void deleteEmail(int id) {
    Email email = getEmailById(id);
    if (email != null) {
      entityManager.remove(email);
    }
  }

  @Transactional
  public void update(Email email) {
    if (email != null) {
      entityManager.merge(email);
    }
  }
}
