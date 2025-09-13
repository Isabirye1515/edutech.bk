package org.edutech.Student.valueholder.dtos;

public class ClubDTO {
  private int id;
  private String clubColor;
  private String clubName;
  private String description;
  private String clubLabel;

  public ClubDTO() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getClubColor() {
    return clubColor;
  }

  public void setClubColor(String clubColor) {
    this.clubColor = clubColor;
  }

  public String getClubName() {
    return clubName;
  }

  public void setClubName(String clubName) {
    this.clubName = clubName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getClubLabel() {
    return clubLabel;
  }

  public void setClubLabel(String clubLabel) {
    this.clubLabel = clubLabel;
  }
}
