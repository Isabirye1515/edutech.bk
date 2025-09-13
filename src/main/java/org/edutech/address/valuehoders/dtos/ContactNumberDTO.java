package org.edutech.address.valuehoders.dtos;

public class ContactNumberDTO {
  private int id;
  private String uuid;
  private String contactNumber;
  private String description;

  public ContactNumberDTO(int id, String uuid, String contactNumber, String description) {
    this.id = id;
    this.uuid = uuid;
    this.contactNumber = contactNumber;
    this.description = description;
  }

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

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  // getters and setters

}
