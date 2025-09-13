package org.edutech.address.valuehoders;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class Email {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "uuid")
  private String uuid;

  @Column(name = "email")
  private String email;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "contact_id")
  @JsonBackReference
  private Contact contact;

  public Email() {}

  // Getters and setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }
}
