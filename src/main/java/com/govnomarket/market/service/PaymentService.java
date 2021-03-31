package com.govnomarket.market.service;

import com.govnomarket.market.dto.OrderDTO;
import com.govnomarket.market.dto.PaymentDTO;
import com.govnomarket.market.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentService implements IPaymentService{

    @Autowired
    private IPaymentRepository repository;

    @Override
    public PaymentDTO save(PaymentDTO paymentDto) {
        return PaymentDTO.paymentToPaymentDto(repository.save(PaymentDTO.paymentDtoToPayment(paymentDto)));
    }

    @Override
    public void deleteById(Long paymentId) {
        repository.deleteById(paymentId);
    }

    @Override
    public List<PaymentDTO> findAll() {
        return  PaymentDTO.paymentListToPaymentDtoList(repository.findAll());
    }

    @Override
    public PaymentDTO getOne(Long paymentId) {
        return PaymentDTO.paymentToPaymentDto(repository.getOne(paymentId));
    }

    @Override
    public List<PaymentDTO> findAllByOrderId(Long orderId) {
        return  PaymentDTO.paymentListToPaymentDtoList(repository.findAllByOrderId(orderId));
    }

    @Override
    public List<PaymentDTO> findAllByStatus(String status) {
        return  PaymentDTO.paymentListToPaymentDtoList(repository.findAllByStatus(status));
    }
}
