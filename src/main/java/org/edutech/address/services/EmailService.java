package org.edutech.address.services;

import org.edutech.address.valuehoders.Email;

import java.util.List;

public interface EmailService {
    void addEmail(Email email);
    List<Email> getAllEmails();
    Email getEmailById(int id);
    void deleteEmail(int id);
    void updateEmail(Email email);
    int getCount();
}
