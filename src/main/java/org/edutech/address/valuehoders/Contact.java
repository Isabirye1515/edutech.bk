package org.edutech.address.valuehoders;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "contact_name")
  private String contactName;

  @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private Set<ContactNumber> contact_numbers;

  @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private Set<Email> emails;

  public Contact() {}

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public Set<ContactNumber> getContact_numbers() {
    return contact_numbers;
  }

  public void setContact_numbers(Set<ContactNumber> contact_numbers) {
    this.contact_numbers = contact_numbers;
  }

  public Set<Email> getEmails() {
    return emails;
  }

  public void setEmails(Set<Email> emails) {
    this.emails = emails;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
