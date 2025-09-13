package org.edutech.address.services;

import java.util.List;
import org.edutech.address.valuehoders.Contact;
import org.edutech.address.valuehoders.dtos.ContactDTO;

public interface ContactService {
  void addContact(Contact contact);

  List<ContactDTO> getAllContacts();

  ContactDTO getContactById(int id);

  void deleteContact(int id);

  void updateContact(Contact contact);

  int getCount();
}
