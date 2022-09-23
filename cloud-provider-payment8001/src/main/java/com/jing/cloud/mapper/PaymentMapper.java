package com.jing.cloud.mapper;

import com.jing.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
