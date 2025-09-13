package org.edutech.vistor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "visit_type")
public class VisitType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "reason")
  private String reason;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "visitType", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<VisitTarget> targets;

  public VisitType() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<VisitTarget> getTargets() {
    return targets;
  }

  public void setTargets(List<VisitTarget> targets) {
    this.targets = targets;
  }
}
