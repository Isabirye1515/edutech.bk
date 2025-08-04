package org.edutech.dormitory.valueholders;

import javax.persistence.*;

@Entity
@Table(name = "bed_location")
public class BedLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "wing", nullable = false)
    private String wing;

    @Column(name = "room", nullable = false)
    private String room;

    @Column(name = "description")
    private String description;

    public BedLocation() {}

    // Getters and Setters

    public int getId() {
        return id;
    }
    

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
