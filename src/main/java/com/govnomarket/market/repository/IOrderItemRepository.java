package com.govnomarket.market.repository;

import com.govnomarket.market.entity.OrderItem;
import com.govnomarket.market.entity.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> {
}
