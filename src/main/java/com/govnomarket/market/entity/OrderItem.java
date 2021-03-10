package com.govnomarket.market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDERITEM")
public class OrderItem {

    @EmbeddedId
    @Getter
    @Setter
    OrderItemKey id;

//    @Column(name = "order_id")
//    @Getter
//    @Setter
//    private Long order_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    @MapsId("order_id")
    @Getter
    @Setter
    private Order order;

//    @Column(name = "product_id")
//    @Getter
//    @Setter
//    private Long product_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    @MapsId("product_id")
    @Getter
    @Setter
    private Product product;

    @Column(name = "count")
    @Getter
    @Setter
    private Long count;

    @Column(name = "price")
    @Getter
    @Setter
    private Double price;

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
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
