package org.edutech.fees.services;

import org.edutech.fees.dao.FeeStudentDao;
import org.edutech.fees.dao.PaidAmountDao;
import org.edutech.fees.valueholder.FeeStudent;
import org.edutech.fees.valueholder.PaidAmount;
import org.edutech.fees.valueholder.dtos.FeeStudentDTO;
import org.edutech.fees.valueholder.dtos.PaidAmountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeStudentService {

    @Autowired
    private FeeStudentDao feeStudentDao;

    @Autowired
    private PaidAmountDao paidAmountDao;

    public void save(FeeStudent feeStudent) {
        feeStudentDao.save(feeStudent);
    }

    public void update(FeeStudent feeStudent) {
        feeStudentDao.update(feeStudent);
    }

    public void delete(int id) {
        feeStudentDao.delete(id);
    }

    public FeeStudentDTO getById(int id) {
        FeeStudent feeStudent = feeStudentDao.getById(id);
        return mapToDTO(feeStudent);
    }

    public List<FeeStudentDTO> getAll() {
        return feeStudentDao.getAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private FeeStudentDTO mapToDTO(FeeStudent feeStudent) {
        FeeStudentDTO dto = new FeeStudentDTO();
        dto.setId(feeStudent.getId());
        dto.setStudentName(feeStudent.getStudentName());
        dto.setStudentId(feeStudent.getStudentId());
        dto.setFees(feeStudent.getFees());
        dto.setAdmitted(feeStudent.isAdmitted());
        dto.setPeriod(feeStudent.getPeriod());

        // Fetch and map paid amounts
        List<PaidAmountDTO> paidAmountDTOs = paidAmountDao.getAll().stream()
                .filter(p -> p.getFeeStudent().getId() == feeStudent.getId())
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        dto.setPaidAmounts(paidAmountDTOs);

        return dto;
    }

    private PaidAmountDTO mapToDTO(PaidAmount paidAmount) {
        PaidAmountDTO dto = new PaidAmountDTO();
        dto.setId(paidAmount.getId());
        dto.setAmount(paidAmount.getAmount());
        dto.setPaidOn(paidAmount.getPaidOn());
        dto.setReceiptOn(paidAmount.getReceiptOn());
        dto.setStudentId(paidAmount.getStudentId());
        dto.setFeeStudentId(paidAmount.getFeeStudent().getId());
        return dto;
    }
}
