package com.logistic.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.logistic.framework.aspectj.lang.annotation.Excel;
import com.logistic.framework.web.domain.BaseEntity;

/**
 * 客户对象 bus_customer
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月4日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class BusCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户ID */
    private Long id;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customername;

    /** 传真 */
    private String zip;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 电话 */
    private String telephone;

    /** 联系人 */
    @Excel(name = "联系人")
    private String connectionpersion;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 银行 */
    @Excel(name = "银行")
    private String bank;

    /** 帐号 */
    @Excel(name = "帐号")
    private String account;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** $column.columnComment */
    @Excel(name = "邮箱")
    private String fax;

    /** 是否可用 */
    private String available;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustomername(String customername) 
    {
        this.customername = customername;
    }

    public String getCustomername() 
    {
        return customername;
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
    public void setConnectionpersion(String connectionpersion) 
    {
        this.connectionpersion = connectionpersion;
    }

    public String getConnectionpersion() 
    {
        return connectionpersion;
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
    public void setAvailable(String available) 
    {
        this.available = available;
    }

    public String getAvailable() 
    {
        return available;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customername", getCustomername())
            .append("zip", getZip())
            .append("address", getAddress())
            .append("telephone", getTelephone())
            .append("connectionpersion", getConnectionpersion())
            .append("phone", getPhone())
            .append("bank", getBank())
            .append("account", getAccount())
            .append("email", getEmail())
            .append("fax", getFax())
            .append("available", getAvailable())
            .toString();
    }
}
