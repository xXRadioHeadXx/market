package com.govnomarket.market.dto;

import com.govnomarket.market.entity.Address;
import com.govnomarket.market.entity.Order;
import com.govnomarket.market.entity.Order;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
@EqualsAndHashCode
public class OrderDTO {
    private Long id;
    private AddressDTO address;
    private Date createDatetime;
    private String status;

    //    @Transactional
    public static OrderDTO orderToOrderDto(Order order) {
        if(null == order)
            return null;

        OrderDTO orderDto = new OrderDTO();

        orderDto.setId(order.getId());
        orderDto.setAddress(AddressDTO.addressToAddressDto(order.getAddress()));
        orderDto.setCreateDatetime(order.getCreateDatetime());
        orderDto.setStatus(order.getStatus());

        return orderDto;
    }

    //    @Transactional
    public static List<OrderDTO> orderListToOrderDtoList(List<Order> orderList){
        List<OrderDTO> orderDtoList = new ArrayList<>();

        for (Order order : orderList) {
            OrderDTO orderDto = orderToOrderDto(order);

            if(null != orderDto)
                orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    public static Order orderDtoToOrder(OrderDTO orderDto) {
        if(null == orderDto)
            return null;

        Order order = new Order();

        order.setId(orderDto.getId());
        order.setAddress(AddressDTO.addressDtoToAddress(orderDto.getAddress()));
        order.setCreateDatetime(orderDto.getCreateDatetime());
        order.setStatus(orderDto.getStatus());

        return order;
    }

    public static List<Order> orderDtoListToOrderList(List<OrderDTO> orderDtoList){
        List<Order> orderList = new ArrayList<>();

        for (OrderDTO orderDto : orderDtoList) {
            Order order = orderDtoToOrder(orderDto);

            if(null != order)
                orderList.add(order);
        }
        return orderList;
    }
}
