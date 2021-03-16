package com.govnomarket.market.repository;

import com.govnomarket.market.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
