package com.govnomarket.market.dto;

import com.govnomarket.market.entity.Person;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
@EqualsAndHashCode
public class PersonDTO {
    private Long id;
    private String name;
    private String fullname;
    private String role;
    private String email;
    private String passwordHash;
    private String login;

//    @Transactional
    public static PersonDTO personToPersonDto(Person person) {
        if(null == person)
            return null;

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setFullname(person.getFullname());
        personDTO.setRole(person.getRole());
        personDTO.setEmail(person.getEmail());
        personDTO.setPasswordHash(person.getPasswordHash());
        personDTO.setLogin(person.getLogin());

        return personDTO;
    }

//    @Transactional
    public static List<PersonDTO> personListToPersonDtoList(List<Person> personList){
        List<PersonDTO> personDTOList = new ArrayList<>();

        for (Person person : personList) {
            PersonDTO personDTO = personToPersonDto(person);

            if(null != personDTO)
                personDTOList.add(personDTO);
        }
        return personDTOList;
    }

    public static Person personDtoToPerson(PersonDTO personDto) {
        if(null == personDto)
            return null;

        Person person = new Person();

        person.setId(personDto.getId());
        person.setName(personDto.getName());
        person.setFullname(personDto.getFullname());
        person.setRole(personDto.getRole());
        person.setEmail(personDto.getEmail());
        person.setPasswordHash(personDto.getPasswordHash());
        person.setLogin(personDto.getLogin());

        return person;
    }

    public static List<Person> personDtoListToPersonList(List<PersonDTO> personDtoList){
        List<Person> personList = new ArrayList<>();

        for (PersonDTO personDto : personDtoList) {
            Person person = personDtoToPerson(personDto);

            if(null != person)
                personList.add(person);
        }
        return personList;
    }

}
