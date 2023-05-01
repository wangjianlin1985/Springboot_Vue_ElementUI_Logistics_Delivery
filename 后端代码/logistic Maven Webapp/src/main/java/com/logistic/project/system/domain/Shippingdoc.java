package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 客户单据对象 shippingdoc
 * 
 * @author mg
 * @date 2020-05-17
 */
public class Shippingdoc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品 */
    @Excel(name = "商品")
    private Long goodsid;

    /** 到货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shippingTime;

    /** 仓管员 */
    @Excel(name = "仓管员")
    private String cgy;

    /** 操作员 */
    @Excel(name = "操作员")
    private String operator;

    /** 运送人员 */
    @Excel(name = "运送人员")
    private String shipPerson;

    /** 仓库 */
    @Excel(name = "仓库")
    private String warehouse;

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
    public void setShippingTime(Date shippingTime) 
    {
        this.shippingTime = shippingTime;
    }

    public Date getShippingTime() 
    {
        return shippingTime;
    }
    public void setCgy(String cgy) 
    {
        this.cgy = cgy;
    }

    public String getCgy() 
    {
        return cgy;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setShipPerson(String shipPerson) 
    {
        this.shipPerson = shipPerson;
    }

    public String getShipPerson() 
    {
        return shipPerson;
    }
    public void setWarehouse(String warehouse) 
    {
        this.warehouse = warehouse;
    }

    public String getWarehouse() 
    {
        return warehouse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsid", getGoodsid())
            .append("shippingTime", getShippingTime())
            .append("cgy", getCgy())
            .append("operator", getOperator())
            .append("shipPerson", getShipPerson())
            .append("warehouse", getWarehouse())
            .toString();
    }
}
