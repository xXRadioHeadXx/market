package com.govnomarket.market.repository;

import com.govnomarket.market.entity.Address;
import com.govnomarket.market.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query(value =  " SELECT id, cdate, mdate, address_id, create_datetime, status " +
            " FROM public.\"ORDER\" where address_id = :addressId ",
            nativeQuery = true)
    public List<Order> findAllByAddressId(@Param("addressId") Long addressId);

    @Query(value =  " SELECT id, cdate, mdate, address_id, create_datetime, status " +
            " FROM public.\"ORDER\" where create_datetime = :createDatetime ",
            nativeQuery = true)
    public List<Order> findAllByCreateDatetime(@Param("createDatetime") Date createDatetime);

    @Query(value =  " SELECT id, cdate, mdate, address_id, create_datetime, status " +
            " FROM public.\"ORDER\" where status = :status ",
            nativeQuery = true)
    public List<Order> findAllByStatus(@Param("status") String status);

}
