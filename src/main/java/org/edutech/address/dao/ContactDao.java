package org.edutech.address.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.address.valuehoders.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDao {
  @PersistenceContext private EntityManager entityManager;

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Transactional
  public void addContact(Contact contact) {
    if (contact != null) {
      entityManager.persist(contact);
    }
  }

  @Transactional
  public List<Contact> getAllContacts() {
    String sql = "Select e from Contact e";
    List<Contact> contacts = entityManager.createQuery(sql, Contact.class).getResultList();
    return contacts;
  }

  @Transactional
  public Contact getContactById(int id) {
    String sql = "select e from Contact e where e.id = :id";
    Contact contact =
        entityManager.createQuery(sql, Contact.class).setParameter("id", id).getSingleResult();
    return contact;
  }

  @Transactional
  public void deleteContact(int id) {
    Contact contact = getContactById(id);
    if (contact != null) {
      entityManager.remove(contact);
    }
  }

  @Transactional
  public void updateContact(Contact contact) {
    if (contact != null) {
      entityManager.merge(contact);
    }
  }
}
