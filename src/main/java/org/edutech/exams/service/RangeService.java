package org.edutech.exams.service;

import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.exams.dao.RangesDao;
import org.edutech.exams.valueholders.Ranges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RangeService {

  @Autowired private RangesDao rangesDao;

  public List<Ranges> getAllRanges() {
    return rangesDao.findAll();
  }

  public Ranges getRangeById(int id) {
    Ranges range = rangesDao.findById(id);
    if (range == null) {
      throw new RuntimeException("Range not found with ID: " + id);
    }
    return range;
  }

  @Transactional
  public void createRange(Ranges ranges) {
    rangesDao.save(ranges);
  }

  @Transactional
  public void updateRange(Ranges ranges) {
    Ranges existing = rangesDao.findById(ranges.getId());
    if (existing == null) {
      throw new RuntimeException("Range not found with ID: " + ranges.getId());
    }
    rangesDao.update(ranges);
  }

  @Transactional
  public void deleteRange(int id) {
    rangesDao.deleteById(id);
  }
}
