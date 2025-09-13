package org.edutech.classes.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.classes.placeholders.Stream;
import org.springframework.stereotype.Repository;

@Repository
public class StreamsDao {

  @PersistenceContext private EntityManager entityManager;

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Transactional
  public void addStream(Stream stream) {
    if (stream != null) {
      entityManager.persist(stream);
    }
  }

  @Transactional
  public List<Stream> getAllStreams() {
    String jpql = "SELECT s FROM Stream s";
    return entityManager.createQuery(jpql, Stream.class).getResultList();
  }

  @Transactional
  public Stream getStreamByStreamNumber(String streamNumber) {
    String jpql = "SELECT s FROM Stream s WHERE s.streamNumber = :streamNumber";
    try {
      return entityManager
          .createQuery(jpql, Stream.class)
          .setParameter("streamNumber", streamNumber)
          .getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  @Transactional
  public Stream getStreamById(int id) {
    return entityManager.find(Stream.class, id);
  }

  /** ✅ NEW METHOD: Fetch stream with students to avoid lazy loading issues */
  @Transactional
  public Stream getStreamWithStudentsById(int id) {
    String jpql = "SELECT s FROM Stream s LEFT JOIN FETCH s.students WHERE s.id = :id";
    try {
      return entityManager.createQuery(jpql, Stream.class).setParameter("id", id).getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  @Transactional
  public void updateStream(Stream stream) {
    if (stream != null) {
      entityManager.merge(stream);
    }
  }

  @Transactional
  public void deleteStream(int id) {
    Stream stream = entityManager.find(Stream.class, id);
    if (stream != null) {
      entityManager.remove(stream);
    }
  }
}
