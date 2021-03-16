package com.govnomarket.market.service;

import com.govnomarket.market.dto.PersonDTO;
import com.govnomarket.market.entity.Person;
import com.govnomarket.market.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository repository;

    @Override
    public PersonDTO save(PersonDTO person) {
        return PersonDTO.personToPersonDto(repository.save(PersonDTO.personDtoToPerson(person)));
    }

    @Override
    public void deleteById(long personId) {
        repository.deleteById(personId);
    }

    @Override
    public List<PersonDTO> findAll() {
        return PersonDTO.personListToPersonDtoList(repository.findAll());
    }

    @Override
    public PersonDTO getOne(long personId) {
        return PersonDTO.personToPersonDto(repository.getOne(personId));
    }

    @Override
    public List<PersonDTO> findAllByName(String name) {
        return PersonDTO.personListToPersonDtoList(repository.findAllByName(name));
    }

    @Override
    public List<PersonDTO> findAllByFullname(String fullname) {
        return PersonDTO.personListToPersonDtoList(repository.findAllByFullname(fullname));
    }

    @Override
    public List<PersonDTO> findAllByRole(String role) {
        return PersonDTO.personListToPersonDtoList(repository.findAllByRole(role));
    }

    @Override
    public List<PersonDTO> findAllByEmail(String email) {
        return PersonDTO.personListToPersonDtoList(repository.findAllByEmail(email));
    }

    @Override
    public List<PersonDTO> findAllByLogin(String login) {
        return PersonDTO.personListToPersonDtoList(repository.findAllByLogin(login));
    }

    @Override
    public List<PersonDTO> findAllByBirthdate(Date birthdate) {
        return PersonDTO.personListToPersonDtoList(repository.findAllByBirthdate(birthdate));
    }

    @Override
    public PersonDTO getByPasswordHashLogin(String passwordHash, String login) {
        List<Person> list = repository.getByPasswordHashLogin(passwordHash, login);
        if(null == list)
            return null;
        else if(1 != list.size())
            return null;
        return PersonDTO.personToPersonDto(list.get(0));
    }

    @Override
    public Long getIdByPasswordHashLogin(String passwordHash, String login) {
        PersonDTO personDto = getByPasswordHashLogin(passwordHash, login);
        if(null == personDto)
            return null;
        else
            return personDto.getId();
    }
}
