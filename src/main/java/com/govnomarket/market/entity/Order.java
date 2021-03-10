package com.govnomarket.market.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDER")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column(name = "address_id")
    @Getter
    @Setter
    private Long address_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Address.class)
    @JoinColumn(name = "address_id")
    @Getter
    @Setter
    private Address address;

    @Column(name = "create_datetime")
    @Getter
    @Setter
    private Date create_datetime;

    @Column(name = "status")
    @Getter
    @Setter
    private String status;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((address_id == null) ? 0 : address_id.hashCode());
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
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (address_id == null) {
            if (other.address_id != null)
                return false;
        }  else if (!id.equals(other.id) || !address_id.equals(other.address_id))
            return false;
        return true;
    }
}
