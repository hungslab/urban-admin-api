package com.hungslab.urban.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 * @TableName sys_product
 */
@Data
public class Product implements Serializable {
    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 产品标题
     */
    private String productTitle;

    /**
     * 商品图片
     */
    private String productAvatar;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 商品销量
     */
    private Integer productSaleCount;

    /**
     * 帐号状态（0上架 1下架）
     */
    private String productStatus;

    /**
     * 创建时间
     */
    private Date productCreateTime;

    private static final long serialVersionUID = 1L;
}