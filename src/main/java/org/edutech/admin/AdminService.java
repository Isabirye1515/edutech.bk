package org.edutech.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin getAdminById(int id) {
        return adminDao.getAdminById(id);
    }

    public List<Admin> getAllAdmins() {
        return adminDao.getAllAdmins();
    }

    public void createAdmin(Admin admin) {
        adminDao.createAdmin(admin);
    }

    public void deleteAdminById(int id) {
        adminDao.deleteAdminById(id);
    }
    public Admin getAdminByUserNameAndPassword(String userName,String password){
        Admin admin = adminDao.getAdminByUserNameAndPassword(userName,password);
        return admin;
    }
}
