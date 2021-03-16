package com.govnomarket.market.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ORDERITEM")
@Getter
@Setter
@EqualsAndHashCode
public class OrderItem {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name="orderId",
                    column=@Column(name="order_id")),
            @AttributeOverride(name="productId",
                    column=@Column(name="product_id"))
    })
    OrderItemKey id;

//    @Column(name = "order_id")
//    @Getter
//    @Setter
//    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    @MapsId("orderId")
    private Order order;

//    @Column(name = "product_id")
//    @Getter
//    @Setter
//    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    private Product product;

    @Column(name = "count")
    private Long count;

    @Column(name = "price")
    private Double price;
}
