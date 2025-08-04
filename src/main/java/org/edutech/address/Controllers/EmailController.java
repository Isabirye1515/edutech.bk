package org.edutech.address.Controllers;

import org.edutech.address.services.EmailService;
import org.edutech.address.valuehoders.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> addEmail(@RequestBody Email email) {
        emailService.addEmail(email);
        return ResponseEntity.ok("Email created successfully");
    }

    @GetMapping
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable int id) {
        Email email = emailService.getEmailById(id);
        if (email != null) {
            return ResponseEntity.ok(email);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmail(@PathVariable int id, @RequestBody Email updatedEmail) {
        Email existingEmail = emailService.getEmailById(id);
        if (existingEmail != null) {
            updatedEmail.setId(id);
            emailService.updateEmail(updatedEmail);
            return ResponseEntity.ok("Email updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmail(@PathVariable int id) {
        Email email = emailService.getEmailById(id);
        if (email != null) {
            emailService.deleteEmail(id);
            return ResponseEntity.ok("Email deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
