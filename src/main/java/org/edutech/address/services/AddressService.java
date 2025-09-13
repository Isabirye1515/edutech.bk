package org.edutech.address.services;

import java.util.List;
import org.edutech.address.valuehoders.Address;

public interface AddressService {
  void addAddress(Address address);

  List<Address> getAllAddresses();

  Address getAddressById(int id);

  void deleteAddress(int id);

  void updateAddress(Address address);
}
