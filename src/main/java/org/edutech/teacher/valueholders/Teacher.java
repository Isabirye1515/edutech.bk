package org.edutech.teacher.valueholders;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import org.edutech.address.valuehoders.Address;
import org.edutech.address.valuehoders.Contact;
import org.edutech.subject.valueholder.Subject;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Subject> subjects;

    public Teacher() {}

    // Getters and setters...

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUuid() { return uuid; }

    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMiddleName() { return middleName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public Date getDob() { return dob; }

    public void setDob(Date dob) { this.dob = dob; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Contact getContact() { return contact; }

    public void setContact(Contact contact) { this.contact = contact; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public List<Subject> getSubjects() { return subjects; }

    public void setSubjects(List<Subject> subjects) { this.subjects = subjects; }
}
