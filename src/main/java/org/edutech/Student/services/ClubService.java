package org.edutech.Student.services;

import org.edutech.Student.valueholder.Club;

import java.util.List;

public interface ClubService {
    void addClub(Club club);
    List<Club> getAllClubs();
    Club getClubById(int id);
    void deleteClub(int id);
    void updateClub(Club club);
}
