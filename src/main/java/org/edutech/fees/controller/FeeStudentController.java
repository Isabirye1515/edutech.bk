package org.edutech.fees.controller;

import java.util.List;
import org.edutech.fees.services.FeeStudentService;
import org.edutech.fees.valueholder.FeeStudent;
import org.edutech.fees.valueholder.dtos.FeeStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fees/students")
public class FeeStudentController {

  @Autowired private FeeStudentService feeStudentService;

  @PostMapping
  public void save(@RequestBody FeeStudent feeStudent) {
    feeStudentService.save(feeStudent);
  }

  @PutMapping
  public void update(@RequestBody FeeStudent feeStudent) {
    feeStudentService.update(feeStudent);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    feeStudentService.delete(id);
  }

  @GetMapping("/{id}")
  public FeeStudentDTO getById(@PathVariable int id) {
    return feeStudentService.getById(id);
  }

  @GetMapping
  public List<FeeStudentDTO> getAll() {
    return feeStudentService.getAll();
  }
}
