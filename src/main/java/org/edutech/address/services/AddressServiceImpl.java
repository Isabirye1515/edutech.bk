package org.edutech.address.services;

import org.edutech.address.dao.AddressDao;
import org.edutech.address.valuehoders.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public void addAddress(Address address) {
        addressDao.addAddress(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressDao.getAllAddresses();
    }

    @Override
    public Address getAddressById(int id) {
        return addressDao.getAddressById(id);
    }

    @Override
    public void deleteAddress(int id) {
        addressDao.deleteAddress(id);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.update(address);
    }
}
