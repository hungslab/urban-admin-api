package com.hungslab.urban.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author hungs
 * @date 2024-04-08
 * @Description
 */
@Data
public class OperationLog {

    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    private Long operId;

    /**
     * 操作内容描述
     */
    private String description;

    /**
     * 操作人员
     */
    private String operName;

    /**
     * 主机地址
     */
    private String operIp;

    /**
     * 操作类别
     */
    private Integer operatorType;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 请求参数
     */
    private String operParam;

    /**
     * 返回参数
     */
    private String jsonResult;

    /**
     * 操作时间
     */
    private Date operTime;

    /**
     * 备注
     */
    private String remark;

}
