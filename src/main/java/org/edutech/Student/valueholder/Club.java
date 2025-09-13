package org.edutech.Student.valueholder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "club")
public class Club {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "color")
  private String clubColor;

  @Column(name = "club_name")
  private String clubName;

  @Column(name = "description")
  private String description;

  @Column(name = "label")
  private String clubLabel;

  public Club() {}

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
