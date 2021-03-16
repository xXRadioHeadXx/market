package com.govnomarket.market.repository;

import com.govnomarket.market.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IPersonRepository extends JpaRepository<Person, Long> {

    @Query(value =  " SELECT id, cdate, mdate, name, fullname, role, email, password_hash, login, birthdate " +
                    " FROM public.\"PERSON\" " +
                    " WHERE name = :name ",
            nativeQuery = true)
    List<Person> findAllByName(@Param("name") String name);

    @Query(value =  " SELECT id, cdate, mdate, name, fullname, role, email, password_hash, login, birthdate " +
            " FROM public.\"PERSON\" " +
            " WHERE fullname = :fullname ",
            nativeQuery = true)
    List<Person> findAllByFullname(@Param("fullname") String fullname);

    @Query(value =  " SELECT id, cdate, mdate, name, fullname, role, email, password_hash, login, birthdate " +
            " FROM public.\"PERSON\" " +
            " WHERE role = :role ",
            nativeQuery = true)
    List<Person> findAllByRole(@Param("role") String role);

    @Query(value =  " SELECT id, cdate, mdate, name, fullname, role, email, password_hash, login, birthdate " +
            " FROM public.\"PERSON\" " +
            " WHERE email = :email ",
            nativeQuery = true)
    List<Person> findAllByEmail(@Param("email") String email);

    @Query(value =  " SELECT id, cdate, mdate, name, fullname, role, email, password_hash, login, birthdate " +
            " FROM public.\"PERSON\" " +
            " WHERE login = :login ",
            nativeQuery = true)
    List<Person> findAllByLogin(@Param("login") String login);

    @Query(value =  " SELECT id, cdate, mdate, name, fullname, role, email, password_hash, login, birthdate " +
            " FROM public.\"PERSON\" " +
            " WHERE birthdate = :birthdate ",
            nativeQuery = true)
    List<Person> findAllByBirthdate(@Param("birthdate") Date birthdate);

    @Query(value =  " SELECT id, cdate, mdate, name, fullname, role, email, password_hash, login, birthdate " +
            " FROM public.\"PERSON\" " +
            " WHERE password_hash = :passwordHash and  login = :login ",
            nativeQuery = true)
    public List<Person>  getByPasswordHashLogin(@Param("passwordHash") String passwordHash, @Param("login") String login);


}
