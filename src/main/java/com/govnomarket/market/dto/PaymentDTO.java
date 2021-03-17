package com.govnomarket.market.dto;

import com.govnomarket.market.entity.Payment;
import com.govnomarket.market.entity.Order;
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
public class PaymentDTO {
    private Long id;
    private OrderDTO order;
    private String status;

    //    @Transactional
    public static PaymentDTO paymentToPaymentDto(Payment payment) {
        if(null == payment)
            return null;

        PaymentDTO paymentDto = new PaymentDTO();

        paymentDto.setId(payment.getId());
        paymentDto.setOrder(OrderDTO.orderToOrderDto(payment.getOrder()));
        paymentDto.setStatus(payment.getStatus());

        return paymentDto;
    }

    //    @Transactional
    public static List<PaymentDTO> paymentListToPaymentDtoList(List<Payment> paymentList){
        List<PaymentDTO> paymentDtoList = new ArrayList<>();

        for (Payment payment : paymentList) {
            PaymentDTO paymentDto = paymentToPaymentDto(payment);

            if(null != paymentDto)
                paymentDtoList.add(paymentDto);
        }
        return paymentDtoList;
    }

    public static Payment paymentDtoToPayment(PaymentDTO paymentDto) {
        if(null == paymentDto)
            return null;

        Payment payment = new Payment();

        payment.setId(paymentDto.getId());
        payment.setOrder(OrderDTO.orderDtoToOrder(paymentDto.getOrder()));
        payment.setStatus(paymentDto.getStatus());

        return payment;
    }

    public static List<Payment> paymentDtoListToPaymentList(List<PaymentDTO> paymentDtoList){
        List<Payment> paymentList = new ArrayList<>();

        for (PaymentDTO paymentDto : paymentDtoList) {
            Payment payment = paymentDtoToPayment(paymentDto);

            if(null != payment)
                paymentList.add(payment);
        }
        return paymentList;
    }

}
