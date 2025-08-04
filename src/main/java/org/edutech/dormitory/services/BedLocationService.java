package org.edutech.dormitory.services;

import org.edutech.dormitory.valueholders.BedLocation;

import java.util.List;

public interface BedLocationService {
    void addLocation(BedLocation location);
    List<BedLocation> getAllLocations();
    BedLocation getLocationById(int id);
    void deleteLocation(int id);
    void updateLocation(BedLocation location);
}
