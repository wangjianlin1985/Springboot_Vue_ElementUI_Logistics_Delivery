package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 采购订单管理对象 bus_caigou_order
 * 
 * @author mage
 * @date 2020-05-17
 */
public class BusCaigouOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 采购订单编号 */
    @Excel(name = "采购订单编号")
    private String cgOrderNum;

    /** 供应商 */
    @Excel(name = "供应商")
    private Long providerId;

    /** 采购日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采购日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cgDate;

    /** 采购员 */
    @Excel(name = "采购员")
    private String cgy;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;
    
    private BusProvider busProvider;
    

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCgOrderNum(String cgOrderNum) 
    {
        this.cgOrderNum = cgOrderNum;
    }

    public String getCgOrderNum() 
    {
        return cgOrderNum;
    }
    public void setProviderId(Long providerId) 
    {
        this.providerId = providerId;
    }

    public Long getProviderId() 
    {
        return providerId;
    }
    public void setCgDate(Date cgDate) 
    {
        this.cgDate = cgDate;
    }

    public Date getCgDate() 
    {
        return cgDate;
    }
    public void setCgy(String cgy) 
    {
        this.cgy = cgy;
    }

    public String getCgy() 
    {
        return cgy;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
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
            .append("cgOrderNum", getCgOrderNum())
            .append("providerId", getProviderId())
            .append("cgDate", getCgDate())
            .append("cgy", getCgy())
            .append("state", getState())
            .toString();
    }
}
