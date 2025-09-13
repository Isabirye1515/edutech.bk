package org.edutech.address.Controllers;

import java.util.List;
import org.edutech.address.services.ContactService;
import org.edutech.address.valuehoders.Contact;
import org.edutech.address.valuehoders.dtos.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

  @Autowired private ContactService contactService;

  @PostMapping
  public ResponseEntity<String> addContact(@RequestBody Contact contact) {
    contactService.addContact(contact);
    return ResponseEntity.ok("Contact created successfully");
  }

  @GetMapping
  public List<ContactDTO> getAllContacts() {
    return contactService.getAllContacts();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ContactDTO> getContactById(@PathVariable int id) {
    ContactDTO contact = contactService.getContactById(id);
    if (contact != null) {
      return ResponseEntity.ok(contact);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateContact(
      @PathVariable int id, @RequestBody Contact updatedContact) {
    ContactDTO existing = contactService.getContactById(id);
    if (existing != null) {
      updatedContact.setId(id);
      contactService.updateContact(updatedContact);
      return ResponseEntity.ok("Contact updated successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteContact(@PathVariable int id) {
    ContactDTO contact = contactService.getContactById(id);
    if (contact != null) {
      contactService.deleteContact(id);
      return ResponseEntity.ok("Contact deleted successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
