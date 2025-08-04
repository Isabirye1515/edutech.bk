package org.edutech.fees.services;

import org.edutech.fees.dao.PaidAmountDao;
import org.edutech.fees.valueholder.PaidAmount;
import org.edutech.fees.valueholder.dtos.PaidAmountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaidAmountService {

    @Autowired
    private PaidAmountDao paidAmountDao;

    public void save(PaidAmount paidAmount) {
        paidAmountDao.save(paidAmount);
    }

    public void update(PaidAmount paidAmount) {
        paidAmountDao.update(paidAmount);
    }

    public void delete(int id) {
        paidAmountDao.delete(id);
    }

    public PaidAmountDTO getById(int id) {
        PaidAmount paidAmount = paidAmountDao.getById(id);
        return mapToDTO(paidAmount);
    }

    public List<PaidAmountDTO> getAll() {
        return paidAmountDao.getAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
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
