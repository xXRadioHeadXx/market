package com.govnomarket.market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column(name = "order_id")
    @Getter
    @Setter
    private Long order_id;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    @Getter
    @Setter
    private Order order;

    @Column(name = "status")
    @Getter
    @Setter
    private String status;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
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
        Payment other = (Payment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (order_id == null) {
            if (other.order_id != null)
                return false;
        } else if (!id.equals(other.id) || !order_id.equals(other.order_id))
            return false;
        return true;
    }
}
