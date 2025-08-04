package org.edutech.address.valuehoders.dtos;

public class EmailDTO {
    private int id;
    private String uuid;
    private String email;
    private String description;

    public EmailDTO(int id, String uuid, String email, String description) {
        this.id = id;
        this.uuid = uuid;
        this.email = email;
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

    // getters and setters

    
}
