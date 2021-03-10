package com.govnomarket.market.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
class OrderItemKey implements Serializable {

    @Column(name = "order_id")
    @Getter
    @Setter
    Long order_id;

    @Column(name = "product_id")
    @Getter
    @Setter
    Long product_id;


    public OrderItemKey() {
    }

    public OrderItemKey(Long order_id, Long product_id) {
        this.order_id = order_id;
        this.product_id = product_id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
        result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
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
        OrderItemKey other = (OrderItemKey) obj;
        if (order_id == null) {
            if (other.order_id != null)
                return false;
        } else if (product_id == null) {
            if (other.product_id != null)
                return false;
        } else if (!order_id.equals(other.order_id) || !product_id.equals(other.product_id))
            return false;
        return true;
    }
}
