package org.edutech.vistor.service;

import java.util.List;
import java.util.stream.Collectors;
import org.edutech.vistor.VisitType;
import org.edutech.vistor.dao.VisitTypeDao;
import org.edutech.vistor.dtos.VisitTargetDTO;
import org.edutech.vistor.dtos.VisitTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitTypeService {

  @Autowired private VisitTypeDao visitTypeDao;

  public void save(VisitType type) {
    visitTypeDao.save(type);
  }

  public VisitTypeDTO getById(int id) {
    VisitType type = visitTypeDao.findById(id);
    if (type == null) {
      return null;
    }
    return toDTO(type);
  }

  public List<VisitTypeDTO> getAll() {
    return visitTypeDao.findAll().stream().map(this::toDTO).collect(Collectors.toList());
  }

  public void update(VisitType type) {
    visitTypeDao.update(type);
  }

  public void delete(int id) {
    visitTypeDao.delete(id);
  }

  private VisitTypeDTO toDTO(VisitType type) {
    VisitTypeDTO dto = new VisitTypeDTO();
    dto.setId(type.getId());
    dto.setReason(type.getReason());
    dto.setDescription(type.getDescription());

    if (type.getTargets() != null) {
      List<VisitTargetDTO> targetDTOs =
          type.getTargets().stream()
              .map(
                  target -> {
                    VisitTargetDTO targetDTO = new VisitTargetDTO();
                    targetDTO.setId(target.getId());
                    targetDTO.setNames(target.getNames());
                    targetDTO.setRole(target.getRole());
                    targetDTO.setPosition(target.getPosition());
                    // Assuming you want to set the visitTypeId for reference, avoid recursive loops
                    targetDTO.setVisitTypeId(type.getId());
                    return targetDTO;
                  })
              .collect(Collectors.toList());
      dto.setVisitTargets(targetDTOs);
    }

    return dto;
  }
}
