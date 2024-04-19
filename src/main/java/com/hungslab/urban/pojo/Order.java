package com.hungslab.urban.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 * @TableName sys_order
 */
@Data
public class Order implements Serializable {
    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单商品名称
     */
    private String orderName;

    /**
     * 下单用户
     */
    private String orderUser;

    /**
     * 支付方式
     */
    private String payWay;

    /**
     * 订单价格
     */
    private String orderPrice;

    /**
     * 订单状态（1上架 0下架）
     */
    private String orderStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}