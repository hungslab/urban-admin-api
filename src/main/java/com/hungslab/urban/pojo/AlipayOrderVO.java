package com.hungslab.urban.pojo;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hungs
 * @date 2024-05-06
 * @Description 支付宝商品结算信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlipayOrderVO {
    /**
     * 支付编号
     */
    private String out_trade_no;
    /**
     * 商品名称
     */
    private String subject;
    /**
     * 订单总金额
     */
    private double total_amount;
    /**
     * 支付宝常量
     */
    private String product_code="FAST_INSTANT_TRADE_PAY";

}
