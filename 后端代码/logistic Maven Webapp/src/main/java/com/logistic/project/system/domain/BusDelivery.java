package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 配送运输对象 bus_delivery
 * 
 * @author nuoyi
 * @date 2020-05-07
 */
public class BusDelivery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品 */
    @Excel(name = "商品")
    private Long goodsid;

    /** 配送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "配送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryTime;

    /** 配送人员 */
    @Excel(name = "配送人员")
    private String deliveryPerson;

    /** 配送地址 */
    @Excel(name = "配送地址")
    private String address;

    /** 操作员 */
    @Excel(name = "操作员")
    private String operator;
    
    private BusGoods busGoods;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodsid(Long goodsid) 
    {
        this.goodsid = goodsid;
    }

    public Long getGoodsid() 
    {
        return goodsid;
    }
    public void setDeliveryTime(Date deliveryTime) 
    {
        this.deliveryTime = deliveryTime;
    }

    public Date getDeliveryTime() 
    {
        return deliveryTime;
    }
    public void setDeliveryPerson(String deliveryPerson) 
    {
        this.deliveryPerson = deliveryPerson;
    }

    public String getDeliveryPerson() 
    {
        return deliveryPerson;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }

    public BusGoods getBusGoods()
    {
        return busGoods;
    }

    public void setBusGoods(BusGoods busGoods)
    {
        this.busGoods = busGoods;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsid", getGoodsid())
            .append("deliveryTime", getDeliveryTime())
            .append("deliveryPerson", getDeliveryPerson())
            .append("address", getAddress())
            .append("operator", getOperator())
            .toString();
    }
}
