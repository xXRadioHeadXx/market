package com.govnomarket.market.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PERSON")
@Getter
@Setter
@EqualsAndHashCode
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "login")
    private String login;

    @Column(name = "birthdate")
    private Date birthdate;

}
