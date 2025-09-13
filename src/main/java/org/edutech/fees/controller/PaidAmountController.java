package org.edutech.fees.controller;

import java.util.List;
import org.edutech.fees.services.PaidAmountService;
import org.edutech.fees.valueholder.PaidAmount;
import org.edutech.fees.valueholder.dtos.PaidAmountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fees/paid-amounts")
public class PaidAmountController {

  @Autowired private PaidAmountService paidAmountService;

  @PostMapping
  public void save(@RequestBody PaidAmount paidAmount) {
    paidAmountService.save(paidAmount);
  }

  @PutMapping
  public void update(@RequestBody PaidAmount paidAmount) {
    paidAmountService.update(paidAmount);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    paidAmountService.delete(id);
  }

  @GetMapping("/{id}")
  public PaidAmountDTO getById(@PathVariable int id) {
    return paidAmountService.getById(id);
  }

  @GetMapping
  public List<PaidAmountDTO> getAll() {
    return paidAmountService.getAll();
  }
}
