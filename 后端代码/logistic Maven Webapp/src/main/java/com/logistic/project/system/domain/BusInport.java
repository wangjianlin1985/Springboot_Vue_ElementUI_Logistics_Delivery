package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 采购管理对象 bus_inport
 * 
 * @author nuoyi
 * @date 2020-05-06
 */
public class BusInport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 支付类型 */
    @Excel(name = "支付类型")
    private String paytype;

    /** 进货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "进货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inporttime;

    /** 操作员 */
    @Excel(name = "操作员")
    private String operateperson;

    /** 进货数量 */
    @Excel(name = "进货数量")
    private Long number;

    /** 进货价格 */
    @Excel(name = "进货价格")
    private Double inportprice;

    /** 供货商 */
    
    /** 商品id */
    @Excel(name = "商品id")
    private Long goodsid;

    
    private BusGoods busGoods;
   

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPaytype(String paytype) 
    {
        this.paytype = paytype;
    }

    public String getPaytype() 
    {
        return paytype;
    }
    public void setInporttime(Date inporttime) 
    {
        this.inporttime = inporttime;
    }

    public Date getInporttime() 
    {
        return inporttime;
    }
    public void setOperateperson(String operateperson) 
    {
        this.operateperson = operateperson;
    }

    public String getOperateperson() 
    {
        return operateperson;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setInportprice(Double inportprice) 
    {
        this.inportprice = inportprice;
    }

    public Double getInportprice() 
    {
        return inportprice;
    }
    public void setGoodsid(Long goodsid) 
    {
        this.goodsid = goodsid;
    }

    public Long getGoodsid() 
    {
        return goodsid;
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
            .append("paytype", getPaytype())
            .append("inporttime", getInporttime())
            .append("operateperson", getOperateperson())
            .append("number", getNumber())
            .append("remark", getRemark())
            .append("inportprice", getInportprice())
            .append("goodsid", getGoodsid())
            .toString();
    }
}
