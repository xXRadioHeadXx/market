package com.govnomarket.market.service;

import com.govnomarket.market.dto.PersonDTO;
import com.govnomarket.market.entity.Person;

import java.util.Date;
import java.util.List;

public interface IPersonService {
    public PersonDTO save(PersonDTO person);

    public void deleteById(Long personId);

    public List<PersonDTO> findAll();
    public PersonDTO getOne(Long personId);
    public List<PersonDTO> findAllByName(String name);
    public List<PersonDTO> findAllByFullname(String fullname);
    public List<PersonDTO> findAllByRole(String role);
    public List<PersonDTO> findAllByEmail(String email);
    public List<PersonDTO> findAllByLogin(String login);
    public List<PersonDTO> findAllByBirthdate(Date birthdate);

    public PersonDTO  getByPasswordHashLogin(String passwordHash, String login);
    public Long getIdByPasswordHashLogin(String passwordHash, String login);
}
