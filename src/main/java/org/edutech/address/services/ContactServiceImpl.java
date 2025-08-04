package org.edutech.address.services;

import org.edutech.address.dao.ContactDao;
import org.edutech.address.valuehoders.Contact;
import org.edutech.address.valuehoders.dtos.ContactDTO;
import org.edutech.address.valuehoders.dtos.ContactNumberDTO;
import org.edutech.address.valuehoders.dtos.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactDao.getAllContacts();
        return contacts.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDTO getContactById(int id) {
        Contact contact = contactDao.getContactById(id);
        return mapToDTO(contact);
    }

    @Override
    public void deleteContact(int id) {
        contactDao.deleteContact(id);
    }

    @Override
    public void updateContact(Contact contact) {
        contactDao.updateContact(contact);
    }

    @Override
    public int getCount() {
        return contactDao.getAllContacts().size();
    }

    private ContactDTO mapToDTO(Contact contact) {
        List<EmailDTO> emails = contact.getEmails() != null
            ? contact.getEmails().stream()
                .map(email -> new EmailDTO(
                        email.getId(),
                        email.getUuid(),
                        email.getEmail(),
                        email.getDescription()))
                .collect(Collectors.toList())
            : List.of();

        List<ContactNumberDTO> numbers = contact.getContact_numbers() != null
            ? contact.getContact_numbers().stream()
                .map(num -> new ContactNumberDTO(
                        num.getId(),
                        num.getUuid(),
                        num.getContactNumber(),
                        num.getDescription()))
                .collect(Collectors.toList())
            : List.of();

        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setContactName(contact.getContactName());
        contactDTO.setEmails(emails);
        contactDTO.setContactNumbers(numbers);
        return contactDTO;
    }
}
