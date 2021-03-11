package com.govnomarket.market.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@EqualsAndHashCode
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter private Long id;

    @Column(name = "user_id")
    @Getter
    @Setter private Long user_id;

//    @Column(name = "user_id")
//    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Person person;

    @Column(name = "address")
    private String address;
}
