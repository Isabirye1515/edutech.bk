package org.edutech.admin;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createAdmin(Admin admin) {
        if (admin != null) {
            entityManager.persist(admin);
        }
    }

    @Transactional
    public Admin getAdminById(int id) {
        String sql = "select s from Admin s where s.id = :id";
        return entityManager.createQuery(sql, Admin.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }

    @Transactional
    public List<Admin> getAllAdmins() {
        return entityManager.createQuery("select s from Admin s", Admin.class)
                            .getResultList();
    }

    @Transactional
    public void deleteAdminById(int id) {
        Admin admin = entityManager.find(Admin.class, id);
        if (admin != null) {
            entityManager.remove(admin);
        }
    }


@Transactional
public Admin getAdminByUserNameAndPassword(String userName, String password) {
    try {
        Query query = entityManager.createNativeQuery(
            "SELECT * FROM admin WHERE user_name = :userName AND password = :password", Admin.class);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        return (Admin) query.getSingleResult();
    } catch (NoResultException e) {
        return null; // no matching admin found
    }
}

}

