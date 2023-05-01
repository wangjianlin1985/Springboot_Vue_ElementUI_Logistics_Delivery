package com.logistic.project.system.service;

import java.util.List;

import com.logistic.project.system.domain.BusCustomer;

/**
 * 客户Service接口
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface IBusCustomerService 
{
    /**
     * 查询客户
     * 
     * @param id 客户ID
     * @return 客户
     */
    public BusCustomer selectBusCustomerById(Long id);

    /**
     * 查询客户列表
     * 
     * @param busCustomer 客户
     * @return 客户集合
     */
    public List<BusCustomer> selectBusCustomerList(BusCustomer busCustomer);

    /**
     * 新增客户
     * 
     * @param busCustomer 客户
     * @return 结果
     */
    public int insertBusCustomer(BusCustomer busCustomer);

    /**
     * 修改客户
     * 
     * @param busCustomer 客户
     * @return 结果
     */
    public int updateBusCustomer(BusCustomer busCustomer);

    /**
     * 批量删除客户
     * 
     * @param ids 需要删除的客户ID
     * @return 结果
     */
    public int deleteBusCustomerByIds(Long[] ids);

    /**
     * 删除客户信息
     * 
     * @param id 客户ID
     * @return 结果
     */
    public int deleteBusCustomerById(Long id);
}
