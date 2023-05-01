package com.logistic.project.system.mapper;

import java.util.List;

import com.logistic.project.system.domain.BusCustomer;

/**
 * 客户Mapper接口
 * 
 * @author nuoyi
 * @date 2020-05-05
 */
public interface BusCustomerMapper 
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
     * 删除客户
     * 
     * @param id 客户ID
     * @return 结果
     */
    public int deleteBusCustomerById(Long id);

    /**
     * 批量删除客户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusCustomerByIds(Long[] ids);
}
