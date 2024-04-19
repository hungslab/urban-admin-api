package com.hungslab.urban.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付方式表
 * @TableName sys_payway
 */
public class Payway implements Serializable {
    /**
     * 支付方式ID
     */
    private Long paywayId;

    /**
     * 订单商品名称
     */
    private String paywayName;

    /**
     * 订单状态（0启用 1禁止）
     */
    private String paywayStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 支付方式ID
     */
    public Long getPaywayId() {
        return paywayId;
    }

    /**
     * 支付方式ID
     */
    public void setPaywayId(Long paywayId) {
        this.paywayId = paywayId;
    }

    /**
     * 订单商品名称
     */
    public String getPaywayName() {
        return paywayName;
    }

    /**
     * 订单商品名称
     */
    public void setPaywayName(String paywayName) {
        this.paywayName = paywayName;
    }

    /**
     * 订单状态（0启用 1禁止）
     */
    public String getPaywayStatus() {
        return paywayStatus;
    }

    /**
     * 订单状态（0启用 1禁止）
     */
    public void setPaywayStatus(String paywayStatus) {
        this.paywayStatus = paywayStatus;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Payway other = (Payway) that;
        return (this.getPaywayId() == null ? other.getPaywayId() == null : this.getPaywayId().equals(other.getPaywayId()))
            && (this.getPaywayName() == null ? other.getPaywayName() == null : this.getPaywayName().equals(other.getPaywayName()))
            && (this.getPaywayStatus() == null ? other.getPaywayStatus() == null : this.getPaywayStatus().equals(other.getPaywayStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPaywayId() == null) ? 0 : getPaywayId().hashCode());
        result = prime * result + ((getPaywayName() == null) ? 0 : getPaywayName().hashCode());
        result = prime * result + ((getPaywayStatus() == null) ? 0 : getPaywayStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paywayId=").append(paywayId);
        sb.append(", paywayName=").append(paywayName);
        sb.append(", paywayStatus=").append(paywayStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}