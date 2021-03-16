package com.govnomarket.market.controller;

import com.govnomarket.market.dto.PersonDTO;
import com.govnomarket.market.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    @PostMapping("/add")
    public PersonDTO add(PersonDTO person) {
        return service.save(person);
    }

    @DeleteMapping("/delete/{personId}")
    public void delete(long personId) {
        service.deleteById(personId);
    }

    @GetMapping("/all")
    public List<PersonDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/one/{personId}")
    public PersonDTO getOne(long personId) {
        return service.getOne(personId);
    }

    @GetMapping("/byName/{name}")
    public List<PersonDTO> getByName(String name) {
        return service.findAllByName(name);
    }

    @GetMapping("/byFullname/{fullname}")
    public List<PersonDTO> getByFullname(String fullname) {
        return service.findAllByFullname(fullname);
    }

    @GetMapping("/byRole/{role}")
    public List<PersonDTO> getByRole(String role) {
        return service.findAllByRole(role);
    }

    @GetMapping("/byEmail/{email}")
    public List<PersonDTO> getByEmail(String email) {
        return service.findAllByEmail(email);
    }

    @GetMapping("/byLogin/{login}")
    public List<PersonDTO> getByLogin(String login) {
        return service.findAllByLogin(login);
    }

    @GetMapping("/byBirthdate/{birthdate}")
    public List<PersonDTO> getByBirthdate(Date birthdate) {
        return service.findAllByBirthdate(birthdate);
    }

    @GetMapping("/byPasswordHashLogin/{passwordHash, login}")
    public PersonDTO getByPasswordHashLogin(String passwordHash, String login) {
        return service.getByPasswordHashLogin(passwordHash, login);
    }

    @GetMapping("/idByPasswordHashLogin/{passwordHash, login}")
    public Long getIdByPasswordHashLogin(String passwordHash, String login) {
        return service.getIdByPasswordHashLogin(passwordHash, login);
    }

    @PutMapping("/edit/{person}")
    public PersonDTO edit(PersonDTO person) {
        return service.save(person);
    }
}
