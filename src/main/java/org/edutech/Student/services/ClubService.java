package org.edutech.Student.services;

import java.util.List;
import org.edutech.Student.valueholder.Club;

public interface ClubService {
  void addClub(Club club);

  List<Club> getAllClubs();

  Club getClubById(int id);

  void deleteClub(int id);

  void updateClub(Club club);
}
