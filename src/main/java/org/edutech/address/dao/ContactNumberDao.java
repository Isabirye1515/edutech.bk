package org.edutech.address.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.edutech.address.valuehoders.ContactNumber;
import org.springframework.stereotype.Repository;

@Repository
public class ContactNumberDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public void addContactNumber(ContactNumber number){
        if(number != null){
            entityManager.persist(number);
        }

    }
    @Transactional
    public List<ContactNumber> getAllContactNumbers(){
        String sql = "Select e from ContactNumber e";
        List<ContactNumber> numbers = entityManager.createQuery(sql,ContactNumber.class)
        .getResultList();
        return numbers;
    }

@Transactional
public ContactNumber getContactNumberById(int id){
    String sql = "select e from ContactNumber e where e.id = :id";
    return entityManager.createQuery(sql, ContactNumber.class)
                        .setParameter("id", id)
                        .getSingleResult();
}

    @Transactional
    public void deleteContactNumber(int id){
        ContactNumber number = getContactNumberById(id);
        if(number != null){
            entityManager.remove(number);
        }

    }
    @Transactional
    public void update(ContactNumber number){
        if(number != null){
     entityManager.merge(number);
            
        }

    }
    

    

    
}
