package org.edutech.address.services;

import org.edutech.address.valuehoders.ContactNumber;

import java.util.List;

public interface ContactNumberService {
    void addContactNumber(ContactNumber number);
    List<ContactNumber> getAllContactNumbers();
    ContactNumber getContactNumberById(int id);
    void deleteContactNumber(int id);
    void updateContactNumber(ContactNumber number);
}
