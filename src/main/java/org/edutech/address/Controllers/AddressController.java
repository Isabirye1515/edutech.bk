package org.edutech.address.Controllers;

import org.edutech.address.services.AddressService;
import org.edutech.address.valuehoders.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<String> addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
        return ResponseEntity.ok("Address created successfully");
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable int id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable int id, @RequestBody Address updatedAddress) {
        Address existingAddress = addressService.getAddressById(id);
        if (existingAddress != null) {
            updatedAddress.setId(id);
            addressService.updateAddress(updatedAddress);
            return ResponseEntity.ok("Address updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            addressService.deleteAddress(id);
            return ResponseEntity.ok("Address deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
