package com.logistic.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 采购物料明细对象 caigou_order_info
 * 
 * @author mag
 * @date 2020-05-19
 */
public class CaigouOrderInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNum;

    /** 商品 */
    @Excel(name = "商品")
    private Long goodId;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 单位 */
    @Excel(name = "单位")
    private String company;
    
    private BusGoods busGoods;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }
    public void setGoodId(Long goodId) 
    {
        this.goodId = goodId;
    }

    public Long getGoodId() 
    {
        return goodId;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
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
            .append("orderNum", getOrderNum())
            .append("goodId", getGoodId())
            .append("num", getNum())
            .append("company", getCompany())
            .toString();
    }
}
