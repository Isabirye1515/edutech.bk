package org.edutech.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
    System.out.print(loginRequest);
    Admin admin = adminService.getAdminByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
    System.out.println("Admin: " + admin);
    
    if (admin == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    String token = JwtUtil.generateToken(admin.getUserName());
    System.out.println("Generated Token: " + token);

    return ResponseEntity.ok(Map.of("token", token));

} catch (Exception e) {
    e.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
}

}
}
