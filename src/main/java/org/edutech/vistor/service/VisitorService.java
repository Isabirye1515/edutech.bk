package org.edutech.vistor.service;

import org.edutech.vistor.Vistor;
import org.edutech.vistor.dao.VisitorDao;
import org.edutech.vistor.dtos.VisitTargetDTO;
import org.edutech.vistor.dtos.VisitTypeDTO;
import org.edutech.vistor.dtos.VisitorDTO;
import org.edutech.address.valuehoders.Contact;
import org.edutech.address.valuehoders.dtos.AddressDTO;
import org.edutech.address.valuehoders.dtos.ContactDTO;
import org.edutech.address.valuehoders.dtos.ContactNumberDTO;
import org.edutech.address.valuehoders.dtos.EmailDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    public void save(Vistor visitor) {
        visitorDao.save(visitor);
    }

    public Vistor getRawById(int id) {
        return visitorDao.findById(id);
    }

    public VisitorDTO getById(int id) {
        Vistor visitor = visitorDao.findById(id);
        return toDTO(visitor);
    }

    public List<VisitorDTO> getAll() {
        return visitorDao.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void update(Vistor visitor) {
        visitorDao.update(visitor);
    }

    public void delete(int id) {
        visitorDao.delete(id);
    }

    private VisitorDTO toDTO(Vistor visitor) {
        VisitorDTO dto = new VisitorDTO();
        dto.setId(visitor.getId());
        dto.setFirstName(visitor.getFirstName());
        dto.setLastName(visitor.getLastName());
        dto.setMiddleName(visitor.getMiddleName());
        dto.setVisitDate(visitor.getVisitdDate());
        dto.setArrivedAt(visitor.getArrivedAt());
        dto.setDepartedAt(visitor.getDepartedAt());

        // Address mapping
        if (visitor.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setCountry(visitor.getAddress().getCountry());
            addressDTO.setVillage(visitor.getAddress().getVillage());
            addressDTO.setParish(visitor.getAddress().getParish());
            addressDTO.setSubcounty(visitor.getAddress().getSubcounty());
            addressDTO.setCounty(visitor.getAddress().getCounty());
            dto.setAddress(addressDTO);
        }

        // Contact mapping
        Contact contact = visitor.getContact();
        if (contact != null) {
            List<EmailDTO> emails = contact.getEmails() != null
                    ? contact.getEmails().stream()
                    .map(email -> new EmailDTO(
                            email.getId(),
                            email.getUuid(),
                            email.getEmail(),
                            email.getDescription()))
                    .collect(Collectors.toList())
                    : List.of();

            List<ContactNumberDTO> contactNumbers = contact.getContact_numbers() != null
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
            contactDTO.setContactNumbers(contactNumbers);

            dto.setContact(contactDTO);
        } else {
            dto.setContact(null);
        }

        // VisitType & VisitTargets mapping
        if (visitor.getVisitType() != null) {
            VisitTypeDTO typeDTO = new VisitTypeDTO();
            typeDTO.setId(visitor.getVisitType().getId());
            typeDTO.setReason(visitor.getVisitType().getReason());
            typeDTO.setDescription(visitor.getVisitType().getDescription());

            if (visitor.getVisitType().getTargets() != null) {
                List<VisitTargetDTO> targets = visitor.getVisitType().getTargets()
                        .stream()
                        .map(target -> {
                            VisitTargetDTO targetDTO = new VisitTargetDTO();
                            targetDTO.setId(target.getId());
                            targetDTO.setNames(target.getNames());
                            targetDTO.setRole(target.getRole());
                            targetDTO.setPosition(target.getPosition());
                            targetDTO.setVisitTypeId(visitor.getVisitType().getId());
                            return targetDTO;
                        })
                        .collect(Collectors.toList());
                typeDTO.setVisitTargets(targets);
            }

            dto.setVisitType(typeDTO);
        }

        return dto;
    }
}
