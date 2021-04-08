package com.govnomarket.market.repository;

import com.govnomarket.market.dto.AddressDTO;
import com.govnomarket.market.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    @Query(value =  " SELECT id, cdate, mdate, user_id, address " +
            " FROM public.\"ADDRESS\" where user_id = :personId ",
            nativeQuery = true)
    public List<Address> findAllByPersonId(@Param("personId") Long personId);

    @Query(value =  " SELECT id, cdate, mdate, user_id, address " +
            " FROM public.\"ADDRESS\" where address = :address ",
            nativeQuery = true)
    public List<Address> findAllByAddress(@Param("address") String address);

}
