package org.edutech.parent.services;

import java.util.List;
import java.util.stream.Collectors;
import org.edutech.Student.dao.StudentDao;
import org.edutech.Student.valueholder.Student;
import org.edutech.address.dao.AddressDao;
import org.edutech.address.dao.ContactDao;
import org.edutech.address.valuehoders.Address;
import org.edutech.address.valuehoders.Contact;
import org.edutech.address.valuehoders.dtos.AddressDTO;
import org.edutech.address.valuehoders.dtos.ContactDTO;
import org.edutech.parent.dao.ParentDao;
import org.edutech.parent.valueholder.Parent;
import org.edutech.parent.valueholder.dto.ParentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService {

  @Autowired private ParentDao parentDao;

  @Autowired private ContactDao contactDao;

  @Autowired private AddressDao addressDao;

  @Autowired private StudentDao studentDao;

  @Override
  public void saveParent(ParentDTO dto) {
    Parent parent = toEntity(dto);
    parentDao.saveParent(parent);
  }

  @Override
  public ParentDTO getParentById(int id) {
    Parent parent = parentDao.getParentById(id);
    return toDto(parent);
  }

  @Override
  public void updateParent(ParentDTO dto) {
    Parent parent = toEntity(dto);
    parentDao.updateParent(parent);
  }

  @Override
  public void deleteParent(int id) {
    parentDao.deleteParent(id);
  }

  @Override
  public List<ParentDTO> getAllParents() {
    return parentDao.getAllParents().stream().map(this::toDto).collect(Collectors.toList());
  }

  // ========== MAPPING METHODS ==========

  private Parent toEntity(ParentDTO dto) {
    Parent parent = new Parent();
    parent.setId(dto.getId());
    parent.setFullName(dto.getFullName());

    if (dto.getContact() != null) {
      Contact contact = contactDao.getContactById(dto.getContact().getId());
      parent.setContact(contact);
    }

    if (dto.getAddress() != null) {
      Address address = addressDao.getAddressById(dto.getAddress().getId());
      parent.setAddress(address);
    }

    if (dto.getStudentId() > 0) {
      Student student = studentDao.getStudentById(dto.getStudentId());
      parent.setStudent(student);
    }

    return parent;
  }

  private ParentDTO toDto(Parent parent) {
    ParentDTO dto = new ParentDTO();
    dto.setId(parent.getId());
    dto.setFullName(parent.getFullName());

    if (parent.getAddress() != null) {
      Address a = parent.getAddress();
      AddressDTO addressDTO = new AddressDTO();
      addressDTO.setId(a.getId());
      addressDTO.setCountry(a.getCountry());
      addressDTO.setCounty(a.getCounty());
      addressDTO.setParish(a.getParish());
      addressDTO.setSubcounty(a.getSubcounty());
      addressDTO.setVillage(a.getVillage());
      dto.setAddress(addressDTO);
    }

    if (parent.getContact() != null) {
      Contact c = parent.getContact();
      ContactDTO contactDTO = new ContactDTO();
      contactDTO.setId(c.getId());
      contactDTO.setContactName(c.getContactName());
      // You can include emails/contactNumbers here if needed
      dto.setContact(contactDTO);
    }

    if (parent.getStudent() != null) {
      dto.setStudentId(parent.getStudent().getId());
    }

    return dto;
  }
}
