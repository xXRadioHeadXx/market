package com.govnomarket.market.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
@Getter
@Setter
@EqualsAndHashCode
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "order_id")
//    private Long orderId;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "status")
    private String status;
}
