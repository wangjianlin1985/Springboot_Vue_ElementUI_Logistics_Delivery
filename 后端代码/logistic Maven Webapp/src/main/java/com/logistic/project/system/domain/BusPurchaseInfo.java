package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 申请物料明细对象 bus_purchase_info
 * 
 * @author mg
 * @date 2020-05-18
 */
public class BusPurchaseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 采购订单编号 */
   
    private String purchaseNum;

    /** 商品 */
    @Excel(name = "商品")
    private Long goodId;
    
    private BusGoods busGoods;
    
    private BusPurchase busPurchase;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPurchaseNum(String purchaseNum) 
    {
        this.purchaseNum = purchaseNum;
    }

    public String getPurchaseNum() 
    {
        return purchaseNum;
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
    public void setPurchaseDate(Date purchaseDate) 
    {
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate() 
    {
        return purchaseDate;
    }

    public BusGoods getBusGoods()
    {
        return busGoods;
    }

    public void setBusGoods(BusGoods busGoods)
    {
        this.busGoods = busGoods;
    }

    public BusPurchase getBusPurchase()
    {
        return busPurchase;
    }

    public void setBusPurchase(BusPurchase busPurchase)
    {
        this.busPurchase = busPurchase;
    }

}
