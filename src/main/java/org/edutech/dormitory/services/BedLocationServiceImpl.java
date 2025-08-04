package org.edutech.dormitory.services;

import org.edutech.dormitory.dao.BedLocationDao;
import org.edutech.dormitory.valueholders.BedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BedLocationServiceImpl implements BedLocationService {

    @Autowired
    private BedLocationDao bedLocationDao;

    @Override
    public void addLocation(BedLocation location) {
        bedLocationDao.addLocation(location);
    }

    @Override
    public List<BedLocation> getAllLocations() {
        return bedLocationDao.getAllLocations();
    }

    @Override
    public BedLocation getLocationById(int id) {
        return bedLocationDao.getLocationById(id);
    }

    @Override
    public void deleteLocation(int id) {
        bedLocationDao.deleteLocation(id);
    }

    @Override
    public void updateLocation(BedLocation location) {
        bedLocationDao.updateLocation(location);
    }
}
