package org.edutech.attendance.controller;

import org.edutech.attendance.Present;
import org.edutech.attendance.dtos.PresentDTO;
import org.edutech.attendance.services.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/presents")
public class PresentController {

    @Autowired
    private  PresentService presentService;


    @GetMapping
    public List<PresentDTO> getAll() {
        return presentService.getAll();
    }

    @GetMapping("/{id}")
    public PresentDTO getById(@PathVariable int id) {
        return presentService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Present present) {
        presentService.save(present);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Present present) {
        present.setId(id);
        presentService.update(present);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        presentService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        presentService.deleteAll();
    }
}
