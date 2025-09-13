package org.edutech.address.Controllers;

import java.util.List;
import org.edutech.address.services.ContactNumberService;
import org.edutech.address.valuehoders.ContactNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact-numbers")
public class ContactNumberController {

  @Autowired private ContactNumberService contactNumberService;

  @PostMapping
  public ResponseEntity<String> addContactNumber(@RequestBody ContactNumber number) {
    contactNumberService.addContactNumber(number);
    return ResponseEntity.ok("Contact number created successfully");
  }

  @GetMapping
  public List<ContactNumber> getAllContactNumbers() {
    return contactNumberService.getAllContactNumbers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ContactNumber> getContactNumberById(@PathVariable int id) {
    ContactNumber number = contactNumberService.getContactNumberById(id);
    if (number != null) {
      return ResponseEntity.ok(number);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateContactNumber(
      @PathVariable int id, @RequestBody ContactNumber updatedNumber) {
    ContactNumber existingNumber = contactNumberService.getContactNumberById(id);
    if (existingNumber != null) {
      updatedNumber.setId(id);
      contactNumberService.updateContactNumber(updatedNumber);
      return ResponseEntity.ok("Contact number updated successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteContactNumber(@PathVariable int id) {
    ContactNumber number = contactNumberService.getContactNumberById(id);
    if (number != null) {
      contactNumberService.deleteContactNumber(id);
      return ResponseEntity.ok("Contact number deleted successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
