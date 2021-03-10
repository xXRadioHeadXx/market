package com.govnomarket.market.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BASKETITEM")
public class BasketItem {

    @EmbeddedId
    @Getter
    @Setter
    BasketItemKey id;

//    @Column(name = "person_id")
//    @Getter
//    @Setter
//    private Long person_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Person.class)
    @JoinColumn(name = "person_id")
    @MapsId("person_id")
    @Getter
    @Setter
    private Person person;

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
        BasketItem other = (BasketItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
