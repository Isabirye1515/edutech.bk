package org.edutech.dormitory.services;

import java.util.List;
import org.edutech.dormitory.valueholders.Bed;

public interface BedService {
  void addBed(Bed bed);

  List<Bed> getAllBeds();

  Bed getBedById(int id);

  void deleteBed(int id);

  void updateBed(Bed bed);
}
