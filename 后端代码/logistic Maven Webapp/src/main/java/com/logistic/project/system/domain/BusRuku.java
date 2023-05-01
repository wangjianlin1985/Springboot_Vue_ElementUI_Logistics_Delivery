package com.logistic.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 入库接单对象 bus_ruku
 * 
 * @author nuoyi
 * @date 2020-05-17
 */
public class BusRuku extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 入库作业单 */
    @Excel(name = "入库作业单")
    private String rukuNum;

    /** 仓管员 */
    @Excel(name = "仓管员")
    private String cgy;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rukuTime;

    /** 到货通知单 */
    @Excel(name = "到货通知单")
    private String dhtz;
    
    
    //采购订单
    private BusCaigouOrder busCaigouOrder;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRukuNum(String rukuNum) 
    {
        this.rukuNum = rukuNum;
    }

    public String getRukuNum() 
    {
        return rukuNum;
    }
    public void setCgy(String cgy) 
    {
        this.cgy = cgy;
    }

    public String getCgy() 
    {
        return cgy;
    }
    public void setRukuTime(Date rukuTime) 
    {
        this.rukuTime = rukuTime;
    }

    public Date getRukuTime() 
    {
        return rukuTime;
    }
   

    public String getDhtz()
    {
        return dhtz;
    }

    public void setDhtz(String dhtz)
    {
        this.dhtz = dhtz;
    }

    public BusCaigouOrder getBusCaigouOrder()
    {
        return busCaigouOrder;
    }

    public void setBusCaigouOrder(BusCaigouOrder busCaigouOrder)
    {
        this.busCaigouOrder = busCaigouOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("rukuNum", getRukuNum())
            .append("cgy", getCgy())
            .append("rukuTime", getRukuTime())
            .append("dhtz", getDhtz())
            .toString();
    }
}
