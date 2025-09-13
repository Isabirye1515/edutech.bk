package org.edutech.attendance.services;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.edutech.attendance.Present;
import org.edutech.attendance.daos.PresentDao;
import org.edutech.attendance.dtos.PresentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PresentService {

  @Autowired private PresentDao presentDao;

  public void save(Present present) {
    presentDao.addPresent(present);
  }

  public List<PresentDTO> getAll() {
    List<Present> presents = presentDao.getAllPresent();
    return presents.stream().map(this::mapToDTO).collect(Collectors.toList());
  }

  public PresentDTO getById(int id) {
    Present present = presentDao.getPresentById(id);
    return mapToDTO(present);
  }

  public void update(Present present) {
    presentDao.updatePresent(present);
  }

  public void deleteById(int id) {
    presentDao.deleteById(id);
  }

  public void deleteAll() {
    presentDao.deleteAll();
  }

  private PresentDTO mapToDTO(Present present) {
    PresentDTO dto = new PresentDTO();
    dto.setId(present.getId());
    dto.setDay(present.getDay());
    dto.setPresent(present.isPresent());
    dto.setAttandenceStudentId(present.getAttendanceStudent().getId());
    return dto;
  }
}
