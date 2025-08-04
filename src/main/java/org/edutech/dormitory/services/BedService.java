package org.edutech.dormitory.services;

import org.edutech.dormitory.valueholders.Bed;
import java.util.List;

public interface BedService {
    void addBed(Bed bed);
    List<Bed> getAllBeds();
    Bed getBedById(int id);
    void deleteBed(int id);
    void updateBed(Bed bed);
}
