package com.govnomarket.market.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name = "BASKETITEM")
@Getter
@Setter
@EqualsAndHashCode
public class BasketItem {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name="personId",
                    column=@Column(name="person_id")),
            @AttributeOverride(name="productId",
                    column=@Column(name="product_id"))
    })
    BasketItemKey id;

//    @Column(name = "person_id")
//    @Getter
//    @Setter
//    private Long personId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinColumn(name = "person_id")
    @MapsId("personId")
    private Person person;

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
}
