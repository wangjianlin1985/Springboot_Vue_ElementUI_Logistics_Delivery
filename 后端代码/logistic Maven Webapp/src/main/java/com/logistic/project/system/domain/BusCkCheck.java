package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 仓库检查对象 bus_ck_check
 * 
 * @author nuoyi
 * @date 2020-05-17
 */
public class BusCkCheck extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 仓库编号 */
    @Excel(name = "仓库编号")
    private String ckNum;

    /** 温度 */
    @Excel(name = "温度")
    private String ckTemp;

    /** 检查人 */
    @Excel(name = "检查人")
    private String checkPerson;

    /** 检查日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检查日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCkNum(String ckNum) 
    {
        this.ckNum = ckNum;
    }

    public String getCkNum() 
    {
        return ckNum;
    }
    public void setCkTemp(String ckTemp) 
    {
        this.ckTemp = ckTemp;
    }

    public String getCkTemp() 
    {
        return ckTemp;
    }
    public void setCheckPerson(String checkPerson) 
    {
        this.checkPerson = checkPerson;
    }

    public String getCheckPerson() 
    {
        return checkPerson;
    }
    public void setCheckDate(Date checkDate) 
    {
        this.checkDate = checkDate;
    }

    public Date getCheckDate() 
    {
        return checkDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ckNum", getCkNum())
            .append("ckTemp", getCkTemp())
            .append("checkPerson", getCheckPerson())
            .append("checkDate", getCheckDate())
            .toString();
    }
}
