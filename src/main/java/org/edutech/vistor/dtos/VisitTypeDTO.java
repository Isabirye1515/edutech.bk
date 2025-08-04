package org.edutech.vistor.dtos;

import java.util.List;

public class VisitTypeDTO {
    private int id;
    private String reason;
    private String description;
    private List<VisitTargetDTO> visitTargets;

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

    public List<VisitTargetDTO> getVisitTargets() {
        return visitTargets;
    }

    public void setVisitTargets(List<VisitTargetDTO> visitTargets) {
        this.visitTargets = visitTargets;
    }
}
