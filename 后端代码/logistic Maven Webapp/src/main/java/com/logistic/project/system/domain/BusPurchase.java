package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 采购申请对象 bus_purchase
 * 
 * @author mg
 * @date 2020-05-17
 */
public class BusPurchase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 采购申请单编号 */
    @Excel(name = "采购申请单编号")
    private String purchaseNum;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseDate;

    /** 完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completeDate;

    /** 申请人 */
    @Excel(name = "申请人")
    private String person;

    /** 采购状态 */
    @Excel(name = "采购状态")
    private Integer purchaseState;

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
    public void setPurchaseDate(Date purchaseDate) 
    {
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate() 
    {
        return purchaseDate;
    }
    public void setCompleteDate(Date completeDate) 
    {
        this.completeDate = completeDate;
    }

    public Date getCompleteDate() 
    {
        return completeDate;
    }
    public void setPerson(String person) 
    {
        this.person = person;
    }

    public String getPerson() 
    {
        return person;
    }
    public void setPurchaseState(Integer purchaseState) 
    {
        this.purchaseState = purchaseState;
    }

    public Integer getPurchaseState() 
    {
        return purchaseState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("purchaseNum", getPurchaseNum())
            .append("purchaseDate", getPurchaseDate())
            .append("completeDate", getCompleteDate())
            .append("person", getPerson())
            .append("purchaseState", getPurchaseState())
            .toString();
    }
}
