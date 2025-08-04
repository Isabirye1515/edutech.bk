package org.edutech.address.valuehoders.dtos;

import java.util.List;

public class ContactDTO {
    private int id;
    private String contactName;
    private List<EmailDTO> emails;
    private List<ContactNumberDTO> contactNumbers;

    public ContactDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public List<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDTO> emails) {
        this.emails = emails;
    }

    public List<ContactNumberDTO> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(List<ContactNumberDTO> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    // getters and setters
    
}
