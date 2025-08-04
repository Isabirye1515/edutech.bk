package org.edutech.teacher.service;

import java.util.List;
import java.util.stream.Collectors;

import org.edutech.address.valuehoders.dtos.AddressDTO;
import org.edutech.address.valuehoders.dtos.ContactDTO;
import org.edutech.address.valuehoders.dtos.ContactNumberDTO;
import org.edutech.address.valuehoders.dtos.EmailDTO;
import org.edutech.subject.valueholder.Subject;
import org.edutech.subject.valueholder.SubjectDTO;
import org.edutech.subject.dao.SubjectDao;
import org.edutech.teacher.dao.TeacherDao;
import org.edutech.teacher.valueholders.Teacher;
import org.edutech.teacher.valueholders.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private SubjectDao subjectDao;

    @Transactional
    public void saveTeacher(Teacher teacher) {
        if (teacher.getSubjects() != null && !teacher.getSubjects().isEmpty()) {
            List<Subject> managedSubjects = teacher.getSubjects().stream()
                .map(subject -> subjectDao.getSubjectById(subject.getId()))
                .filter(s -> s != null)
                .collect(Collectors.toList());
            teacher.setSubjects(managedSubjects);
        }
        teacherDao.saveTeacher(teacher);
    }

    @Transactional(readOnly = true)
    public List<TeacherDTO> getAllTeachers() {
        return teacherDao.getAllTeachers().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Teacher getTeacherById(int id) {
        return teacherDao.getTeacherById(id);
    }

    @Transactional(readOnly = true)
    public TeacherDTO getTeacherDTOById(int id) {
        Teacher teacher = teacherDao.getTeacherById(id);
        return teacher != null ? convertToDTO(teacher) : null;
    }

    @Transactional
    public void updateTeacher(Teacher teacher) {
        if (teacher.getSubjects() != null && !teacher.getSubjects().isEmpty()) {
            List<Subject> managedSubjects = teacher.getSubjects().stream()
                .map(subject -> subjectDao.getSubjectById(subject.getId()))
                .filter(s -> s != null)
                .collect(Collectors.toList());
            teacher.setSubjects(managedSubjects);
        }
        teacherDao.updateTeacher(teacher);
    }

    @Transactional
    public void deleteTeacher(int id) {
        teacherDao.deleteTeacher(id);
    }

    @Transactional
    public void deleteAllTeachers() {
        teacherDao.deleteAllTeachers();
    }

    @Transactional(readOnly = true)
    public Teacher getTeacherByName(String name) {
        return teacherDao.getTeacherByName(name);
    }

    private TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setUuid(teacher.getUuid());
        dto.setFirstName(teacher.getFirstName());
        dto.setLastName(teacher.getLastName());
        dto.setMiddleName(teacher.getMiddleName());
        dto.setDob(teacher.getDob());
        dto.setImageUrl(teacher.getImageUrl());

        if (teacher.getContact() != null) {
            ContactDTO contactDTO = new ContactDTO();
            contactDTO.setId(teacher.getContact().getId());
            contactDTO.setContactName(teacher.getContact().getContactName());

            // Access emails to initialize collection
            if (teacher.getContact().getEmails() != null) {
                contactDTO.setEmails(
                    teacher.getContact().getEmails().stream()
                        .map(email -> new EmailDTO(
                            email.getId(),
                            email.getUuid(),
                            email.getEmail(),
                            email.getDescription()
                        ))
                        .collect(Collectors.toList())
                );
            }

            // Access contactNumbers to initialize collection
            if (teacher.getContact().getContact_numbers() != null) {
                contactDTO.setContactNumbers(
                    teacher.getContact().getContact_numbers().stream()
                        .map(number -> new ContactNumberDTO(
                            number.getId(),
                            number.getUuid(),
                            number.getContactNumber(),
                            number.getDescription()
                        ))
                        .collect(Collectors.toList())
                );
            }

            dto.setContact(contactDTO);
        }

        if (teacher.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setId(teacher.getAddress().getId());
            addressDTO.setCountry(teacher.getAddress().getCountry());
            addressDTO.setCounty(teacher.getAddress().getCounty());
            addressDTO.setSubcounty(teacher.getAddress().getSubcounty());
            addressDTO.setParish(teacher.getAddress().getParish());
            addressDTO.setVillage(teacher.getAddress().getVillage());
            dto.setAddress(addressDTO);
        }

        if (teacher.getSubjects() != null) {
            List<SubjectDTO> subjectDTOs = teacher.getSubjects().stream()
                .map(subject -> {
                    SubjectDTO sDto = new SubjectDTO();
                    sDto.setId(subject.getId());
                    sDto.setUuid(subject.getUuid());
                    sDto.setSubjectName(subject.getSubjectName());
                    sDto.setDescription(subject.getDescription());
                    return sDto;
                }).collect(Collectors.toList());
            dto.setSubjects(subjectDTOs);
        }

        return dto;
    }
}
