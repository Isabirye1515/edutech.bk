package org.edutech.parent.valueholder.dto;

import org.edutech.address.valuehoders.dtos.AddressDTO;
import org.edutech.address.valuehoders.dtos.ContactDTO;

public class ParentDTO {

  private int id;
  private String fullName;

  private ContactDTO contact;
  private AddressDTO address;

  private int studentId;

  public ParentDTO() {}

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public ContactDTO getContact() {
    return contact;
  }

  public void setContact(ContactDTO contact) {
    this.contact = contact;
  }

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }
}
