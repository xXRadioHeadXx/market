package com.govnomarket.market.entity;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "fullname")
    @Getter
    @Setter
    private String fullname;

    @Column(name = "role")
    @Getter
    @Setter
    private String role;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Column(name = "password_hash")
    @Getter
    @Setter
    private String password_hash;

    @Column(name = "login")
    @Getter
    @Setter
    private String login;

    @Column(name = "birthdate")
    @Getter
    @Setter
    private Date birthdate;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
