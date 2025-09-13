package org.edutech.Student.services;

import jakarta.transaction.Transactional;
import java.util.List;
import org.edutech.Student.dao.ClubDao;
import org.edutech.Student.valueholder.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClubServiceImpl implements ClubService {

  @Autowired private ClubDao clubDao;

  @Override
  public void addClub(Club club) {
    clubDao.addClub(club);
  }

  @Override
  public List<Club> getAllClubs() {
    return clubDao.getAllClubs();
  }

  @Override
  public Club getClubById(int id) {
    return clubDao.getClubById(id);
  }

  @Override
  public void deleteClub(int id) {
    clubDao.deleteClub(id);
  }

  @Override
  public void updateClub(Club club) {
    clubDao.updateClub(club);
  }
}
