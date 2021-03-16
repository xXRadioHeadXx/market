package com.govnomarket.market.repository;

import com.govnomarket.market.entity.BasketItem;
import com.govnomarket.market.entity.BasketItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBasketItemRepository extends JpaRepository<BasketItem, BasketItemKey> {
}
