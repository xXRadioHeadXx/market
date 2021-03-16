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
    public List<Product> findAllByName(@Param("name") String name);

    @Query(value =  " SELECT id, cdate, mdate, name, description, category, price " +
            " FROM public.\"PRODUCT\" where description = :description ",
            nativeQuery = true)
    public List<Product> findAllByDescription(@Param("description") String description);


    @Query(value =  " SELECT id, cdate, mdate, name, description, category, price " +
                    " FROM public.\"PRODUCT\" where category = :category ",
           nativeQuery = true)
    public List<Product> findAllByCategory(@Param("category") String category);

    @Query(value = " SELECT id, cdate, mdate, name, description, category, price " +
            " FROM public.\"PRODUCT\" where :to <= price AND price <= :from ",
            nativeQuery = true)
    public List<Product> findAllByPriceFromTo(
            @Param("to") Long to, @Param("from") Long from);
}
