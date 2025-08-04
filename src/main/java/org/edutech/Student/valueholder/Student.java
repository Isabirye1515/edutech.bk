package org.edutech.Student.valueholder;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.edutech.address.valuehoders.Address;
import org.edutech.address.valuehoders.Contact;
import org.edutech.parent.valueholder.Parent;
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="uuid")
    private String uuid;
    @Column(name="school_id")
    private String SchoolId; 
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "first_name")
    private String firstName;
    @Column(name= "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;
    @OneToOne
    @JoinColumn(name = "wing")
    private Club club;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
    
    @OneToMany(mappedBy = "student",
               cascade = javax.persistence.CascadeType.ALL,
               orphanRemoval = true
               )
    private Set<Parent> parents;

    public Student(){}

    

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public Club getClub() {
        return club;
    }



    public void setClub(Club club) {
        this.club = club;
    }



    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(String schoolId) {
        SchoolId = schoolId;
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



    public String getImageUrl() {
        return imageUrl;
    }



    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    public Address getAddress() {
        return address;
    }



    public void setAddress(Address address) {
        this.address = address;
    }



    public Contact getContact() {
        return contact;
    }



    public void setContact(Contact contact) {
        this.contact = contact;
    }



    public Set<Parent> getParents() {
        return parents;
    }



    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }
    
    

    
}
