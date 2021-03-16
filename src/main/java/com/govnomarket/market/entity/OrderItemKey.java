package com.govnomarket.market.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class OrderItemKey implements Serializable {

//    @Column(name = "order_id")
    Long orderId;

//    @Column(name = "product_id")
    Long productId;

    public OrderItemKey() {
    }

    public OrderItemKey(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
