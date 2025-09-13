package org.edutech.address.services;

import java.util.List;
import org.edutech.address.valuehoders.Email;

public interface EmailService {
  void addEmail(Email email);

  List<Email> getAllEmails();

  Email getEmailById(int id);

  void deleteEmail(int id);

  void updateEmail(Email email);

  int getCount();
}
