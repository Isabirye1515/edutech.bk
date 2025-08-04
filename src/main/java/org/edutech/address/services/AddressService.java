package org.edutech.address.services;

import org.edutech.address.valuehoders.Address;

import java.util.List;

public interface AddressService {
    void addAddress(Address address);
    List<Address> getAllAddresses();
    Address getAddressById(int id);
    void deleteAddress(int id);
    void updateAddress(Address address);
}
