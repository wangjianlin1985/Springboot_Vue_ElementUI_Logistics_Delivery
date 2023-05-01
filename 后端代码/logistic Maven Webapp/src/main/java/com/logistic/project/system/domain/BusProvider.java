package com.logistic.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 供应商对象 bus_provider
 * 
 * @author nuoyi
 * @date 2020-05-05
 */
public class BusProvider extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商ID */
    private Long id;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String providername;

    /** $column.columnComment */
    private String zip;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String address;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String telephone;

    /** 联系人 */
    @Excel(name = "联系人")
    private String connectionperson;

    /** 电话 */
    private String phone;

    /** 银行 */
    private String bank;

    /** 帐号 */
    private String account;

    /** 邮箱 */
    private String email;

    /** $column.columnComment */
    private String fax;

    /** 是否可用 */
    private Long available;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProvidername(String providername) 
    {
        this.providername = providername;
    }

    public String getProvidername() 
    {
        return providername;
    }
    public void setZip(String zip) 
    {
        this.zip = zip;
    }

    public String getZip() 
    {
        return zip;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setConnectionperson(String connectionperson) 
    {
        this.connectionperson = connectionperson;
    }

    public String getConnectionperson() 
    {
        return connectionperson;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setBank(String bank) 
    {
        this.bank = bank;
    }

    public String getBank() 
    {
        return bank;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setFax(String fax) 
    {
        this.fax = fax;
    }

    public String getFax() 
    {
        return fax;
    }
    public void setAvailable(Long available) 
    {
        this.available = available;
    }

    public Long getAvailable() 
    {
        return available;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("providername", getProvidername())
            .append("zip", getZip())
            .append("address", getAddress())
            .append("telephone", getTelephone())
            .append("connectionperson", getConnectionperson())
            .append("phone", getPhone())
            .append("bank", getBank())
            .append("account", getAccount())
            .append("email", getEmail())
            .append("fax", getFax())
            .append("available", getAvailable())
            .toString();
    }
}
