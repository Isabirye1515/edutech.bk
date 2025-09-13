package org.edutech.dormitory.services;

import java.util.List;
import org.edutech.dormitory.valueholders.BedLocation;

public interface BedLocationService {
  void addLocation(BedLocation location);

  List<BedLocation> getAllLocations();

  BedLocation getLocationById(int id);

  void deleteLocation(int id);

  void updateLocation(BedLocation location);
}
