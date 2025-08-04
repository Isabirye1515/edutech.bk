package org.edutech.address.services;

import org.edutech.address.valuehoders.Contact;
import org.edutech.address.valuehoders.dtos.ContactDTO;

import java.util.List;

public interface ContactService {
    void addContact(Contact contact);
    List<ContactDTO> getAllContacts();
    ContactDTO getContactById(int id);
    void deleteContact(int id);
    void updateContact(Contact contact);
    int getCount() ;
}
