package org.edutech.classes.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.classes.placeholders.ClassRooms;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDao {

  @PersistenceContext private EntityManager entityManager;

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Transactional
  public void addClassRoom(ClassRooms classRoom) {
    if (classRoom != null) {
      entityManager.persist(classRoom);
    }
  }

  @Transactional
  public List<ClassRooms> getAllClassRooms() {
    String jpql = "SELECT c FROM ClassRooms c";
    return entityManager.createQuery(jpql, ClassRooms.class).getResultList();
  }

  @Transactional
  public ClassRooms getClassRoomByName(String className) {
    String jpql = "SELECT c FROM ClassRooms c WHERE c.className = :className";
    try {
      return entityManager
          .createQuery(jpql, ClassRooms.class)
          .setParameter("className", className)
          .getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  @Transactional
  public void updateClassRoom(ClassRooms classRoom) {
    if (classRoom != null) {
      entityManager.merge(classRoom);
    }
  }

  @Transactional
  public void deleteClassRoom(String className) {
    ClassRooms classRoom = getClassRoomByName(className);
    if (classRoom != null) {
      entityManager.remove(classRoom);
    }
  }

  public ClassRooms getClassRoomById(int id) {
    String jpql = "SELECT c FROM ClassRooms c WHERE c.id = :id";
    try {
      return entityManager
          .createQuery(jpql, ClassRooms.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }
}
