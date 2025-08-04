package org.edutech.address.services;

import org.edutech.address.dao.EmailDao;
import org.edutech.address.valuehoders.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailDao emailDao;

    @Override
    public void addEmail(Email email) {
        emailDao.addEmail(email);
    }

    @Override
    public List<Email> getAllEmails() {
        return emailDao.getAllEmails();
    }

    @Override
    public Email getEmailById(int id) {
        return emailDao.getEmailById(id);
    }

    @Override
    public void deleteEmail(int id) {
        emailDao.deleteEmail(id);
    }

    @Override
    public void updateEmail(Email email) {
        emailDao.update(email);
    }

    @Override
    public int getCount() {
        List<Email> emails = emailDao.getAllEmails();
        int count  = emails.size();
        return count;

    }
}
