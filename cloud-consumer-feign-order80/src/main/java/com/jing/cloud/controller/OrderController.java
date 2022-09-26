package com.jing.cloud.controller;

import com.jing.cloud.entities.CommonResult;
import com.jing.cloud.entities.Payment;
import com.jing.cloud.service.PaymentFeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PaymentFeginService paymentFeginService;

    @PostMapping("/order/create")
    public CommonResult create(Payment payment){
        return paymentFeginService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeginService.getPaymentById(id);
    }

}
