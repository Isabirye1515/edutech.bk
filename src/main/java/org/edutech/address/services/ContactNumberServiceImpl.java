package org.edutech.address.services;

import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.address.dao.ContactNumberDao;
import org.edutech.address.valuehoders.ContactNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContactNumberServiceImpl implements ContactNumberService {

  @Autowired private ContactNumberDao contactNumberDao;

  @Override
  public void addContactNumber(ContactNumber number) {
    contactNumberDao.addContactNumber(number);
  }

  @Override
  public List<ContactNumber> getAllContactNumbers() {
    return contactNumberDao.getAllContactNumbers();
  }

  @Override
  public ContactNumber getContactNumberById(int id) {
    return contactNumberDao.getContactNumberById(id);
  }

  @Override
  public void deleteContactNumber(int id) {
    contactNumberDao.deleteContactNumber(id);
  }

  @Override
  public void updateContactNumber(ContactNumber number) {
    contactNumberDao.update(number);
  }
}
