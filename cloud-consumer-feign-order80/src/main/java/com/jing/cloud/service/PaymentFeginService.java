package com.jing.cloud.service;

import com.jing.cloud.entities.CommonResult;
import com.jing.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeginService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @PostMapping("/payment/create")
    CommonResult<Payment> create(Payment payment);
}
