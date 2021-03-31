package com.govnomarket.market.repository;

import com.govnomarket.market.entity.Payment;
import com.govnomarket.market.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    @Query(value =  " SELECT id, cdate, mdate, order_id, status " +
            " FROM public.\"PAYMENT\"" +
            " WHERE order_id = :orderId ",
            nativeQuery = true)
    List<Payment> findAllByOrderId(@Param("orderId") Long orderId);

    @Query(value =  " SELECT id, cdate, mdate, order_id, status " +
            " FROM public.\"PAYMENT\"" +
            " WHERE order_id = :status ",
            nativeQuery = true)
    List<Payment> findAllByStatus(@Param("status") String status);
}
