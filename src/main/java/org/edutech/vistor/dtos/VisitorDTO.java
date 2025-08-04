package org.edutech.vistor.dtos;

import java.sql.Date;
import java.sql.Time;

import org.edutech.address.valuehoders.dtos.AddressDTO;
import org.edutech.address.valuehoders.dtos.ContactDTO;



public class VisitorDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;

    private ContactDTO contact;
    private AddressDTO address;
    private VisitTypeDTO visitType;

    private Date visitDate;
    private Time arrivedAt;
    private Time departedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public VisitTypeDTO getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitTypeDTO visitType) {
        this.visitType = visitType;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Time getArrivedAt() {
        return arrivedAt;
    }

    public void setArrivedAt(Time arrivedAt) {
        this.arrivedAt = arrivedAt;
    }

    public Time getDepartedAt() {
        return departedAt;
    }

    public void setDepartedAt(Time departedAt) {
        this.departedAt = departedAt;
    }
}
