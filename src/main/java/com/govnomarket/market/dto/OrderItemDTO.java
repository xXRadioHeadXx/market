package com.govnomarket.market.dto;

import com.govnomarket.market.entity.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
@EqualsAndHashCode
public class OrderItemDTO {
    private OrderItemKey id;
    private OrderDTO order;
    private ProductDTO product;
    private Long count;
    private Double price;

    //    @Transactional
    public static OrderItemDTO orderItemToOrderItemDto(OrderItem orderItem) {
        if(null == orderItem)
            return null;

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setOrder(OrderDTO.orderToOrderDto(orderItem.getOrder()));
        orderItemDTO.setProduct(ProductDTO.productToProductDto(orderItem.getProduct()));
        orderItemDTO.setCount(orderItem.getCount());
        orderItemDTO.setPrice(orderItem.getPrice());

        return orderItemDTO;
    }

    //    @Transactional
    public static List<OrderItemDTO> orderItemListToOrderItemDtoList(List<OrderItem> orderItemList){
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        for (OrderItem orderItem : orderItemList) {
            OrderItemDTO orderItemDTO = orderItemToOrderItemDto(orderItem);

            if(null != orderItemDTO)
                orderItemDTOList.add(orderItemDTO);
        }
        return orderItemDTOList;
    }

    public static OrderItem orderItemDtoToOrderItem(OrderItemDTO orderItemDto) {
        if(null == orderItemDto)
            return null;

        OrderItem orderItem = new OrderItem();

        orderItem.setId(orderItemDto.getId());
        orderItem.setOrder(OrderDTO.orderDtoToOrder(orderItemDto.getOrder()));
        orderItem.setProduct(ProductDTO.productDtoToProduct(orderItemDto.getProduct()));
        orderItem.setCount(orderItemDto.getCount());
        orderItem.setPrice(orderItemDto.getPrice());

        return orderItem;
    }

    public static List<OrderItem> orderItemDtoListToOrderItemList(List<OrderItemDTO> orderItemDtoList){
        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderItemDTO orderItemDto : orderItemDtoList) {
            OrderItem orderItem = orderItemDtoToOrderItem(orderItemDto);

            if(null != orderItem)
                orderItemList.add(orderItem);
        }
        return orderItemList;
    }

}
