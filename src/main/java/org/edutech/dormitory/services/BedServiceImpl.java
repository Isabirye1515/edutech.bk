package org.edutech.dormitory.services;

import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.dormitory.dao.BedDao;
import org.edutech.dormitory.valueholders.Bed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BedServiceImpl implements BedService {

  @Autowired private BedDao bedDao;

  @Override
  public void addBed(Bed bed) {
    bedDao.addBed(bed);
  }

  @Override
  public List<Bed> getAllBeds() {
    return bedDao.getAllBeds();
  }

  @Override
  public Bed getBedById(int id) {
    return bedDao.getBedById(id);
  }

  @Override
  public void deleteBed(int id) {
    bedDao.deleteBed(id);
  }

  @Override
  public void updateBed(Bed bed) {
    bedDao.updateBed(bed);
  }
}
