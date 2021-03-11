package com.govnomarket.market.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class BasketItemKey implements Serializable {
//    @Column(name = "person_id")
    private Long personId;

//    @Column(name = "product_id")
    private Long productId;

    public BasketItemKey() {
    }

    public BasketItemKey(Long personId, Long productId) {
        this.personId = personId;
        this.productId = productId;
    }
}
