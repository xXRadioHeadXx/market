package com.govnomarket.market.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDER")
@Getter
@Setter
@EqualsAndHashCode
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "address_id")
//    private Long addressId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Address.class)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private Address address;

    @Column(name = "create_datetime")
    private Date createDatetime;

    @Column(name = "status")
    private String status;
}
