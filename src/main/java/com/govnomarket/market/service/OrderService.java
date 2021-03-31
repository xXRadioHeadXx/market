package com.govnomarket.market.service;

import com.govnomarket.market.dto.OrderDTO;
import com.govnomarket.market.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository repository;

    @Override
    public OrderDTO save(OrderDTO orderDto) {
        return OrderDTO.orderToOrderDto(repository.save(OrderDTO.orderDtoToOrder(orderDto)));
    }

    @Override
    public void deleteById(Long orderId){
        repository.deleteById(orderId);
    }

    @Override
    public List<OrderDTO> findAll() {
        return  OrderDTO.orderListToOrderDtoList(repository.findAll());
    }

    @Override
    public OrderDTO getOne(Long orderId) {
        return OrderDTO.orderToOrderDto(repository.getOne(orderId));
    }

    @Override
    public List<OrderDTO> findAllByAddressId(Long addressId) {
        return  OrderDTO.orderListToOrderDtoList(repository.findAllByAddressId(addressId));
    }

    @Override
    public List<OrderDTO> findAllByCreateDatetime(Date createDatetime) {
        return  OrderDTO.orderListToOrderDtoList(repository.findAllByCreateDatetime(createDatetime));
    }

    @Override
    public List<OrderDTO> findAllByStatus(String status) {
        return  OrderDTO.orderListToOrderDtoList(repository.findAllByStatus(status));
    }
}
