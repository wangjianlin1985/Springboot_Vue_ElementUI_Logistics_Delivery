package com.logistic.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 商品对象 bus_goods
 * 
 * @author nuoyi
 * @date 2020-04-23
 */
public class BusGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsname;

    /** 商品产地 */
    @Excel(name = "商品产地")
    private String produceplace;

    /** 规格 */
    @Excel(name = "规格")
    private String size;

    /** 商品包装 */
    @Excel(name = "商品包装")
    private String goodspackage;

    /** 生产批号 */
    @Excel(name = "生产批号")
    private String productcode;

    /** 批准文号 */
    @Excel(name = "批准文号")
    private String promitcode;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String description;

    /** 销售价格 */
    @Excel(name = "销售价格")
    private Double price;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 告警数量 */
    @Excel(name = "告警数量")
    private Long dangernum;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String goodsimg;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private Long available;

    /** 厂家ID */
    @Excel(name = "厂家ID")
    private Long providerid;
    
    private BusProvider  busProvider;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodsname(String goodsname) 
    {
        this.goodsname = goodsname;
    }

    public String getGoodsname() 
    {
        return goodsname;
    }
    public void setProduceplace(String produceplace) 
    {
        this.produceplace = produceplace;
    }

    public String getProduceplace() 
    {
        return produceplace;
    }
    public void setSize(String size) 
    {
        this.size = size;
    }

    public String getSize() 
    {
        return size;
    }
    public void setGoodspackage(String goodspackage) 
    {
        this.goodspackage = goodspackage;
    }

    public String getGoodspackage() 
    {
        return goodspackage;
    }
    public void setProductcode(String productcode) 
    {
        this.productcode = productcode;
    }

    public String getProductcode() 
    {
        return productcode;
    }
    public void setPromitcode(String promitcode) 
    {
        this.promitcode = promitcode;
    }

    public String getPromitcode() 
    {
        return promitcode;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setDangernum(Long dangernum) 
    {
        this.dangernum = dangernum;
    }

    public Long getDangernum() 
    {
        return dangernum;
    }
    public void setGoodsimg(String goodsimg) 
    {
        this.goodsimg = goodsimg;
    }

    public String getGoodsimg() 
    {
        return goodsimg;
    }
    public void setAvailable(Long available) 
    {
        this.available = available;
    }

    public Long getAvailable() 
    {
        return available;
    }
    public void setProviderid(Long providerid) 
    {
        this.providerid = providerid;
    }

    public Long getProviderid() 
    {
        return providerid;
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
            .append("goodsname", getGoodsname())
            .append("produceplace", getProduceplace())
            .append("size", getSize())
            .append("goodspackage", getGoodspackage())
            .append("productcode", getProductcode())
            .append("promitcode", getPromitcode())
            .append("description", getDescription())
            .append("price", getPrice())
            .append("number", getNumber())
            .append("dangernum", getDangernum())
            .append("goodsimg", getGoodsimg())
            .append("available", getAvailable())
            .append("providerid", getProviderid())
            .append("busProvider",getBusProvider())
            .toString();
    }
}
