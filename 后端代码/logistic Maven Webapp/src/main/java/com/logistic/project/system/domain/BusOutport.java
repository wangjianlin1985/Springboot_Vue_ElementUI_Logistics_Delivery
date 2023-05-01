package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 出库管理对象 bus_outport
 * 
 * @author nuoyi
 * @date 2020-05-07
 */
public class BusOutport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 供应商 */
    @Excel(name = "供应商")
    private Long providerid;

    /** 支付类型 */
    @Excel(name = "支付类型")
    private String paytype;

    /** 退货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outputtime;

    /** 操作员 */
    @Excel(name = "操作员")
    private String operateperson;

    /** 退货价格 */
    @Excel(name = "退货价格")
    private Long outportprice;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 商品 */
    @Excel(name = "商品")
    private Long goodsid;
    
    private BusGoods busGoods;
    private BusProvider busProvider;
    

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProviderid(Long providerid) 
    {
        this.providerid = providerid;
    }

    public Long getProviderid() 
    {
        return providerid;
    }
    public void setPaytype(String paytype) 
    {
        this.paytype = paytype;
    }

    public String getPaytype() 
    {
        return paytype;
    }
    public void setOutputtime(Date outputtime) 
    {
        this.outputtime = outputtime;
    }

    public Date getOutputtime() 
    {
        return outputtime;
    }
    public void setOperateperson(String operateperson) 
    {
        this.operateperson = operateperson;
    }

    public String getOperateperson() 
    {
        return operateperson;
    }
    public void setOutportprice(Long outportprice) 
    {
        this.outportprice = outportprice;
    }

    public Long getOutportprice() 
    {
        return outportprice;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
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

    public BusProvider getBusProvider()
    {
        return busProvider;
    }

    public void setBusProvider(BusProvider busProvider)
    {
        this.busProvider = busProvider;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("providerid", getProviderid())
            .append("paytype", getPaytype())
            .append("outputtime", getOutputtime())
            .append("operateperson", getOperateperson())
            .append("outportprice", getOutportprice())
            .append("number", getNumber())
            .append("remark", getRemark())
            .append("goodsid", getGoodsid())
            .toString();
    }
}
