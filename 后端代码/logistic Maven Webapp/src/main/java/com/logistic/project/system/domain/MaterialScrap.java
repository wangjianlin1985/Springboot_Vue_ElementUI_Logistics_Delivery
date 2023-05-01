package com.logistic.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 物料报废对象 material_scrap <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2020年5月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MaterialScrap extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private Long id;
    
    /** 物料编号 */
    @Excel(name = "物料编号")
    private String materialNum;
    
    /** 规格 */
    @Excel(name = "规格")
    private String specifications;
    
    /** 数量
     *  此处使用weight作为数量属性
     * */
    
    private Long weight;
    
    private Long goodid;
    
    private BusGoods busGoods;
    
    /** 单位 */
    private String company;
    
    /** 报废原因 */
    private String reason;
    
    /** 报废人 */
    @Excel(name = "报废人")
    private String scrapPerson;
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setMaterialNum(String materialNum)
    {
        this.materialNum = materialNum;
    }
    
    public String getMaterialNum()
    {
        return materialNum;
    }
    
    public void setSpecifications(String specifications)
    {
        this.specifications = specifications;
    }
    
    public String getSpecifications()
    {
        return specifications;
    }
    
    public void setWeight(Long weight)
    {
        this.weight = weight;
    }
    
    public Long getWeight()
    {
        return weight;
    }
    
    public void setCompany(String company)
    {
        this.company = company;
    }
    
    public String getCompany()
    {
        return company;
    }
    
    public void setReason(String reason)
    {
        this.reason = reason;
    }
    
    public String getReason()
    {
        return reason;
    }
    
    public void setScrapPerson(String scrapPerson)
    {
        this.scrapPerson = scrapPerson;
    }
    
    public String getScrapPerson()
    {
        return scrapPerson;
    }
    
   
    
    public Long getGoodid()
    {
        return goodid;
    }

    public void setGoodid(Long goodid)
    {
        this.goodid = goodid;
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
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
            .append("materialNum", getMaterialNum())
            .append("specifications", getSpecifications())
            .append("weight", getWeight())
            .append("company", getCompany())
            .append("reason", getReason())
            .append("scrapPerson", getScrapPerson())
            .toString();
    }
}
