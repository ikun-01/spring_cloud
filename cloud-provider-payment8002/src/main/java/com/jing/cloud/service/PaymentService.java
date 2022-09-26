package com.jing.cloud.service;

import com.jing.cloud.entities.Payment;

public interface PaymentService {
    
    int create(Payment payment);
    
    Payment getPaymentById(Long id);
    
}