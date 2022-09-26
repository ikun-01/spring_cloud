package com.jing.cloud.controller;

import com.jing.cloud.entities.CommonResult;
import com.jing.cloud.entities.Payment;
import com.jing.cloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(description = "订单模块")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @ApiOperation("新建订单")
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入操作返回结果:{}",result);
        if (result > 0){
            return new CommonResult(200,"插入数据库一条数据成功!,端口号为:" + serverPort,result);
        }
        return new CommonResult(444,"插入数据失败!",null);
    }

    @ApiOperation("查找订单")
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("Payment=>{}",payment);
        if (payment != null){
            return new CommonResult<Payment>(200,"查找成功!,端口号为:" + serverPort,payment);
        }
        return new CommonResult<Payment>(444,"查找失败,信息不存在!,ID为:" + id,null);
    }
}
