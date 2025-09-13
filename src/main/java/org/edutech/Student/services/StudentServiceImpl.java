package org.edutech.Student.services;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.edutech.Student.dao.StudentDao;
import org.edutech.Student.valueholder.Club;
import org.edutech.Student.valueholder.Student;
import org.edutech.Student.valueholder.dtos.ClubDTO;
import org.edutech.Student.valueholder.dtos.StudentDTO;
import org.edutech.address.valuehoders.Address;
import org.edutech.address.valuehoders.Contact;
import org.edutech.address.valuehoders.dtos.AddressDTO;
import org.edutech.address.valuehoders.dtos.ContactDTO;
import org.edutech.address.valuehoders.dtos.ContactNumberDTO;
import org.edutech.address.valuehoders.dtos.EmailDTO;
import org.edutech.parent.valueholder.Parent;
import org.edutech.parent.valueholder.dto.ParentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

  @Autowired private StudentDao studentDao;

  @Override
  public void addStudent(Student student) {
    studentDao.addStudent(student);
  }

  @Override
  public List<Student> getAllStudents() {
    return studentDao.getAllStudents();
  }

  @Override
  public Student getStudentById(int id) {
    return studentDao.getStudentById(id);
  }

  @Override
  public void deleteStudent(int id) {
    studentDao.deleteStudent(id);
  }

  @Override
  public void updateStudent(Student student) {
    studentDao.updateStudent(student);
  }

  public List<StudentDTO> getAllStudentDTOS() {
    return studentDao.getAllStudents().stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  public StudentDTO getStudentDTOById(int id) {
    Student student = studentDao.getStudentById(id);
    return student != null ? convertToDTO(student) : null;
  }

  private StudentDTO convertToDTO(Student student) {
    StudentDTO dto = new StudentDTO();

    dto.setId(student.getId());
    dto.setUuid(student.getUuid());
    dto.setSchoolId(student.getSchoolId());
    dto.setImageUrl(student.getImageUrl());
    dto.setFirstName(student.getFirstName());
    dto.setMiddleName(student.getMiddleName());
    dto.setLastName(student.getLastName());
    dto.setDob(student.getDob());

    if (student.getClub() != null) {
      Club club = student.getClub();
      ClubDTO clubDTO = new ClubDTO();
      clubDTO.setId(club.getId());
      clubDTO.setClubName(club.getClubName());
      clubDTO.setClubColor(club.getClubColor());
      clubDTO.setClubLabel(club.getClubLabel());
      clubDTO.setDescription(club.getDescription());
      dto.setClub(clubDTO);
    }

    if (student.getAddress() != null) {
      Address a = student.getAddress();
      AddressDTO addressDTO = new AddressDTO();
      addressDTO.setId(a.getId());
      addressDTO.setCountry(a.getCountry());
      addressDTO.setCounty(a.getCounty());
      addressDTO.setParish(a.getParish());
      addressDTO.setSubcounty(a.getSubcounty());
      addressDTO.setVillage(a.getVillage());
      dto.setAddress(addressDTO);
    }

    if (student.getContact() != null) {
      dto.setContact(mapToDTO(student.getContact()));
    }

    if (student.getParents() != null) {
      List<ParentDTO> parentDTOs =
          student.getParents().stream().map(this::toDto).collect(Collectors.toList());
      dto.setParents(parentDTOs);
    }

    return dto;
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
      dto.setContact(mapToDTO(parent.getContact()));
    }

    if (parent.getStudent() != null) {
      dto.setStudentId(parent.getStudent().getId());
    }

    return dto;
  }

  private ContactDTO mapToDTO(Contact contact) {
    List<EmailDTO> emails =
        contact.getEmails() != null
            ? contact.getEmails().stream()
                .map(
                    email ->
                        new EmailDTO(
                            email.getId(),
                            email.getUuid(),
                            email.getEmail(),
                            email.getDescription()))
                .collect(Collectors.toList())
            : List.of();

    List<ContactNumberDTO> numbers =
        contact.getContact_numbers() != null
            ? contact.getContact_numbers().stream()
                .map(
                    num ->
                        new ContactNumberDTO(
                            num.getId(),
                            num.getUuid(),
                            num.getContactNumber(),
                            num.getDescription()))
                .collect(Collectors.toList())
            : List.of();

    ContactDTO contactDTO = new ContactDTO();
    contactDTO.setId(contact.getId());
    contactDTO.setContactName(contact.getContactName());
    contactDTO.setEmails(emails);
    contactDTO.setContactNumbers(numbers);
    return contactDTO;
  }
}
