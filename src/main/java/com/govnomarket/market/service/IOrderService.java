package com.govnomarket.market.service;

import com.govnomarket.market.dto.OrderDTO;

import java.util.Date;
import java.util.List;

public interface IOrderService {
    public OrderDTO save(OrderDTO orderDto);

    public void deleteById(Long orderId);

    public List<OrderDTO> findAll();
    public OrderDTO getOne(Long orderId);
    public List<OrderDTO> findAllByAddressId(Long addressId);
    public List<OrderDTO> findAllByCreateDatetime(Date createDatetime);
    public List<OrderDTO> findAllByStatus(String status);
}
