package org.edutech.address.services;

import java.util.List;
import org.edutech.address.valuehoders.ContactNumber;

public interface ContactNumberService {
  void addContactNumber(ContactNumber number);

  List<ContactNumber> getAllContactNumbers();

  ContactNumber getContactNumberById(int id);

  void deleteContactNumber(int id);

  void updateContactNumber(ContactNumber number);
}
