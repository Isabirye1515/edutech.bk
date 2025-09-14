package org.edutech.admins;

import java.util.List;

import org.edutech.WebContestSensitiveTest;
import org.edutech.admin.Admin;
import org.edutech.admin.AdminService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceTest extends WebContestSensitiveTest{

    @Autowired
    private AdminService adminService;

    @Before
    public void setUp() throws Exception {
        executeDataset("/testdata/admin.xml");
    }
     
    @Test
    public void getAllAdmins_ShouldReturnAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        admins.forEach(admin -> System.out.println(admin.getFirstName()));
    }
    
}
