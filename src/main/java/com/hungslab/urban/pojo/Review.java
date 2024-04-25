package com.hungslab.urban.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品评论表
 * @TableName sys_review
 */
@Data
public class Review implements Serializable {
    /**
     * 
     */
    private Long reviewId;

    /**
     * 
     */
    private String reviewContent;

    /**
     * 
     */
    private Date reviewCreateTime;

    /**
     * 
     */
    private Long reviewUserId;

    /**
     * 
     */
    private Long reviewProductId;

    /**
     * 
     */
    private char reviewStatus;

    private Long reviewOrderId;

    private static final long serialVersionUID = 1L;
}