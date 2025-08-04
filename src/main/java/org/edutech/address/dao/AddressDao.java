package org.edutech.address.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.edutech.address.valuehoders.Address;
import org.springframework.stereotype.Repository;
@Repository
public class AddressDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public void addAddress(Address address){
        if(address != null){
            entityManager.persist(address);
        }

    }
    @Transactional
    public List<Address> getAllAddresses(){
        String sql = "Select e from Address e";
        List<Address> addresses = entityManager.createQuery(sql,Address.class)
        .getResultList();
        return addresses;
    }

    @Transactional
    public Address getAddressById(int id){
        String sql = "select e from Address e where e.id = :id";
        Address address = entityManager.createQuery(sql,Address.class)
        .setParameter("id", id)
        .getSingleResult();
        return address;

    }
    @Transactional
    public void deleteAddress(int id){
        Address address = getAddressById(id);
        if(address != null){
            entityManager.remove(address);
        }

    }
    @Transactional
    public void update(Address address){
        if(address != null){
     entityManager.merge(address);
            
        }

    }
    

    

    
}
