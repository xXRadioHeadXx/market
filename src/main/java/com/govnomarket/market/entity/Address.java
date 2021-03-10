package com.govnomarket.market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter private Long id;

    @Column(name = "user_id")
    @Getter
    @Setter private Long user_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Person.class)
    @JoinColumn(name = "user_id")
    @Getter
    @Setter private Person person;

    @Column(name = "address")
    @Getter
    @Setter private String address;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
        Address other = (Address) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (user_id == null) {
            if (other.user_id != null)
                return false;
        } else if (!id.equals(other.id) || !user_id.equals(other.user_id))
            return false;
        return true;
    }
}
