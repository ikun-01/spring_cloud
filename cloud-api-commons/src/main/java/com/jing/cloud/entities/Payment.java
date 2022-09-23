package com.jing.cloud.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("订单实体类")
public class Payment implements Serializable
{
    @ApiModelProperty(value = "订单ID",hidden = true)
    private Long id;
    private String serial;
}