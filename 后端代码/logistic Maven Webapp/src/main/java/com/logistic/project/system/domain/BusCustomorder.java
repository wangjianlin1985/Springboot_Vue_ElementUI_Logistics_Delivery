package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 客户订单查询对象 bus_customorder
 * 
 * @author mg
 * @date 2020-05-17
 */
public class BusCustomorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String custName;

    /** 订单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    /** 订单类型 */
    @Excel(name = "订单类型")
    private String orderType;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payType;

    /** 状态 */
    private String state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustName(String custName) 
    {
        this.custName = custName;
    }

    public String getCustName() 
    {
        return custName;
    }
    public void setOrderDate(Date orderDate) 
    {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() 
    {
        return orderDate;
    }
    public void setOrderType(String orderType) 
    {
        this.orderType = orderType;
    }

    public String getOrderType() 
    {
        return orderType;
    }
    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("custName", getCustName())
            .append("orderDate", getOrderDate())
            .append("orderType", getOrderType())
            .append("payType", getPayType())
            .append("state", getState())
            .toString();
    }
}
