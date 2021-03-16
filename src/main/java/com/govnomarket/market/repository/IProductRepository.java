package com.govnomarket.market.repository;

import com.govnomarket.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value =  " SELECT id, cdate, mdate, name, description, category, price " +
            " FROM public.\"PRODUCT\" where name = :name ",
            nativeQuery = true)
    List<Product> findByNameEquals(@Param("name") String name);

    @Query(value =  " SELECT id, cdate, mdate, name, description, category, price " +
                    " FROM public.\"PRODUCT\" where category = :category ",
           nativeQuery = true)
    List<Product> findByCategoryEquals(@Param("category") String category);

    @Query(value = " SELECT id, cdate, mdate, name, description, category, price " +
            " FROM public.\"PRODUCT\" where :to <= price AND price <= :from ",
            nativeQuery = true)
    List<Product> findByPriceFromTo(
            @Param("to") Long to, @Param("from") Long from);
}
