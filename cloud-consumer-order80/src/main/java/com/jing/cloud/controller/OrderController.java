package com.jing.cloud.controller;

import com.jing.cloud.entities.CommonResult;
import com.jing.cloud.entities.Payment;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@Api
public class OrderController {
    private static final String paymentSrv_url = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(paymentSrv_url + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/order/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return restTemplate.getForObject(paymentSrv_url + "/payment/get/" + id, CommonResult.class);
    }

}
