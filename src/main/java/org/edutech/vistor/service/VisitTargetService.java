package org.edutech.vistor.service;

import java.util.List;
import java.util.stream.Collectors;
import org.edutech.vistor.VisitTarget;
import org.edutech.vistor.dao.VisitTargetDao;
import org.edutech.vistor.dtos.VisitTargetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitTargetService {

  @Autowired private VisitTargetDao visitTargetDao;

  public void save(VisitTarget target) {
    visitTargetDao.save(target);
  }

  public VisitTargetDTO getById(int id) {
    VisitTarget target = visitTargetDao.findById(id);
    if (target == null) {
      return null;
    }
    return toDTO(target);
  }

  public List<VisitTargetDTO> getAll() {
    return visitTargetDao.findAll().stream().map(this::toDTO).collect(Collectors.toList());
  }

  public void update(VisitTarget target) {
    visitTargetDao.update(target);
  }

  public void delete(int id) {
    visitTargetDao.delete(id);
  }

  private VisitTargetDTO toDTO(VisitTarget target) {
    VisitTargetDTO dto = new VisitTargetDTO();
    dto.setId(target.getId());
    dto.setNames(target.getNames());
    dto.setRole(target.getRole());
    dto.setPosition(target.getPosition());
    // To avoid recursion, set only the visitType ID
    if (target.getVisitType() != null) {
      dto.setVisitTypeId(target.getVisitType().getId());
    }
    return dto;
  }
}
