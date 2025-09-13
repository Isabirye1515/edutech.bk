package org.edutech.vistor;

import jakarta.persistence.*;

@Entity
@Table(name = "visit_target")
public class VisitTarget {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "names")
  private String names;

  @Column(name = "role")
  private String role;

  @Column(name = "position")
  private String position;

  @ManyToOne
  @JoinColumn(name = "visit_type_id")
  private VisitType visitType;

  public VisitTarget() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public VisitType getVisitType() {
    return visitType;
  }

  public void setVisitType(VisitType visitType) {
    this.visitType = visitType;
  }
}
