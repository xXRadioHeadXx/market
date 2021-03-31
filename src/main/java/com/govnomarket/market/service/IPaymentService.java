package com.govnomarket.market.service;

import com.govnomarket.market.dto.PaymentDTO;

import java.util.Date;
import java.util.List;

public interface IPaymentService {
    public PaymentDTO save(PaymentDTO paymentDto);

    public void deleteById(Long paymentId);

    public List<PaymentDTO> findAll();
    public PaymentDTO getOne(Long paymentId);
    public List<PaymentDTO> findAllByOrderId(Long orderId);
    public List<PaymentDTO> findAllByStatus(String status);
}
