package org.edutech.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/admins")
public class AdminController {

  @Autowired private AdminService adminService;

  @GetMapping("/{id}")
  public Admin getAdminById(@PathVariable int id) {
    return adminService.getAdminById(id);
  }

  @GetMapping
  public List<Admin> getAllAdmins() {
    return adminService.getAllAdmins();
  }

  @PostMapping
  public void createAdmin(@RequestBody Admin admin) {
    adminService.createAdmin(admin);
  }

  @DeleteMapping("/{id}")
  public void deleteAdmin(@PathVariable int id) {
    adminService.deleteAdminById(id);
  }
}
