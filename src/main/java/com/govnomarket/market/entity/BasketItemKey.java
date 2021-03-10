package com.govnomarket.market.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BasketItemKey implements Serializable {
    @Column(name = "person_id")
    @Getter
    @Setter
    private Long person_id;

    @Column(name = "product_id")
    @Getter
    @Setter
    private Long product_id;

    public BasketItemKey() {
    }

    public BasketItemKey(Long person_id, Long product_id) {
        this.person_id = person_id;
        this.product_id = product_id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((person_id == null) ? 0 : person_id.hashCode());
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
        BasketItemKey other = (BasketItemKey) obj;
        if (person_id == null) {
            if (other.person_id != null)
                return false;
        } else if (product_id == null) {
            if (other.product_id != null)
                return false;
        } else if (!person_id.equals(other.person_id) || !product_id.equals(other.product_id))
            return false;
        return true;
    }


}
