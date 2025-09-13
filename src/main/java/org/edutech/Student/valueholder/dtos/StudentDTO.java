package org.edutech.Student.valueholder.dtos;

import java.sql.Date;
import java.util.List;
import org.edutech.address.valuehoders.dtos.AddressDTO;
import org.edutech.address.valuehoders.dtos.ContactDTO;
import org.edutech.parent.valueholder.dto.ParentDTO;

public class StudentDTO {
  private int id;
  private String uuid;
  private String schoolId;
  private String imageUrl;
  private String firstName;
  private String middleName;
  private String lastName;
  private Date dob;

  private ClubDTO club;
  private AddressDTO address;
  private ContactDTO contact;
  private List<ParentDTO> parents;

  public StudentDTO() {}

  // Getters and Setters

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

  public String getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(String schoolId) {
    this.schoolId = schoolId;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public ClubDTO getClub() {
    return club;
  }

  public void setClub(ClubDTO club) {
    this.club = club;
  }

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }

  public ContactDTO getContact() {
    return contact;
  }

  public void setContact(ContactDTO contact) {
    this.contact = contact;
  }

  public List<ParentDTO> getParents() {
    return parents;
  }

  public void setParents(List<ParentDTO> parents) {
    this.parents = parents;
  }
}
