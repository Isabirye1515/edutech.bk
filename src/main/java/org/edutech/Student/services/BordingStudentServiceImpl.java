package org.edutech.Student.services;

import org.edutech.Student.dao.BordingStudentDao;
import org.edutech.Student.valueholder.BordingStudent;
import org.edutech.Student.valueholder.Club;
import org.edutech.Student.valueholder.Student;
import org.edutech.Student.valueholder.dtos.BordingStudentDTO;
import org.edutech.Student.valueholder.dtos.ClubDTO;
import org.edutech.Student.valueholder.dtos.StudentDTO;
import org.edutech.address.valuehoders.Address;
import org.edutech.address.valuehoders.Contact;
import org.edutech.address.valuehoders.dtos.AddressDTO;
import org.edutech.address.valuehoders.dtos.ContactDTO;
import org.edutech.address.valuehoders.dtos.ContactNumberDTO;
import org.edutech.address.valuehoders.dtos.EmailDTO;
import org.edutech.dormitory.valueholders.Bed;
import org.edutech.dormitory.valueholders.BedLocation;
import org.edutech.dormitory.valueholders.dto.BedDTO;
import org.edutech.dormitory.valueholders.dto.BedLocationDTO;
import org.edutech.parent.valueholder.Parent;
import org.edutech.parent.valueholder.dto.ParentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BordingStudentServiceImpl implements BordingStudentService {

    @Autowired
    private BordingStudentDao dao;

    @Override
    public void addBordingStudent(BordingStudent bordingStudent) {
        dao.addBordingStudent(bordingStudent);
    }

    @Override
    public List<BordingStudent> getAllBordingStudents() {
        return dao.getAllBordingStudents();
    }

    @Override
    public BordingStudent getBordingStudentById(int id) {
        return dao.getBordingStudentById(id);
    }

    @Override
    public void deleteBordingStudent(int id) {
        dao.deleteBordingStudent(id);
    }

    @Override
    public void updateBordingStudent(BordingStudent bordingStudent) {
        dao.updateBordingStudent(bordingStudent);
    }

    @Override
    public List<BordingStudentDTO> getAllBordingStudentDtos() {
        return dao.getAllBordingStudents().stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }
    @Override
    public BordingStudentDTO getBordingStudentDtoById(int id) {
        BordingStudent entity = dao.getBordingStudentById(id);
        return convertToDto(entity);
    }

    private BordingStudentDTO  convertToDto(BordingStudent entity) {
        BordingStudentDTO dto = new BordingStudentDTO();
        dto.setId(entity.getId());

        if (entity.getStudent() != null) {
            dto.setStudent(convertToDTO(entity.getStudent()));
        }

        if (entity.getBed() != null) {
            dto.setBed(convertBedToDto(entity.getBed()));
        }

        return dto;
    }

    private BedDTO convertBedToDto(Bed bed) {
        BedDTO dto = new BedDTO();
        dto.setId(bed.getId());
        dto.setColumn(bed.getColumn());
        dto.setRow(bed.getRow());
        dto.setLevel(bed.getLevel());

        if (bed.getLocation() != null) {
            dto.setLocation(convertLocationToDTO(bed.getLocation()));
        }

        return dto;
    }

    private BedLocationDTO convertLocationToDTO(BedLocation location) {
        BedLocationDTO dto = new BedLocationDTO();
        dto.setId(location.getId());
        dto.setWing(location.getWing());
        dto.setRoom(location.getRoom());
        dto.setDescription(location.getDescription());
        return dto;
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
            List<ParentDTO> parentDTOs = student.getParents()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
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
        List<EmailDTO> emails = contact.getEmails() != null
            ? contact.getEmails().stream()
                .map(email -> new EmailDTO(
                        email.getId(),
                        email.getUuid(),
                        email.getEmail(),
                        email.getDescription()))
                .collect(Collectors.toList())
            : List.of();

        List<ContactNumberDTO> numbers = contact.getContact_numbers() != null
            ? contact.getContact_numbers().stream()
                .map(num -> new ContactNumberDTO(
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
