package org.edutech.vistor;

import org.edutech.address.valuehoders.Address;
import org.edutech.address.valuehoders.Contact;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "visitor")
public class Vistor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "visit_type_id")
    private VisitType visitType; // ✅ OK

    @Column(name = "visit_date", nullable = true)
    private Date visitdDate;

    @Column(name = "arrived_at")
    private Time arrivedAt;

    @Column(name = "departed_at")
    private Time departedAt;

    public Vistor() {}

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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public VisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }

    public Date getVisitdDate() {
        return visitdDate;
    }

    public void setVisitdDate(Date visitdDate) {
        this.visitdDate = visitdDate;
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
