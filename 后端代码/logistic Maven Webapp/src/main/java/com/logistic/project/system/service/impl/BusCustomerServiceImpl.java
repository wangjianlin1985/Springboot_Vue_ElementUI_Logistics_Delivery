package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.project.system.domain.BusCustomer;
import com.logistic.project.system.mapper.BusCustomerMapper;
import com.logistic.project.system.service.IBusCustomerService;

/**
 * 客户Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-05-05
 */
@Service
public class BusCustomerServiceImpl implements IBusCustomerService 
{
    @Autowired
    private BusCustomerMapper busCustomerMapper;

    /**
     * 查询客户
     * 
     * @param id 客户ID
     * @return 客户
     */
    @Override
    public BusCustomer selectBusCustomerById(Long id)
    {
        return busCustomerMapper.selectBusCustomerById(id);
    }

    /**
     * 查询客户列表
     * 
     * @param busCustomer 客户
     * @return 客户
     */
    @Override
    public List<BusCustomer> selectBusCustomerList(BusCustomer busCustomer)
    {
        return busCustomerMapper.selectBusCustomerList(busCustomer);
    }

    /**
     * 新增客户
     * 
     * @param busCustomer 客户
     * @return 结果
     */
    @Override
    public int insertBusCustomer(BusCustomer busCustomer)
    {
        return busCustomerMapper.insertBusCustomer(busCustomer);
    }

    /**
     * 修改客户
     * 
     * @param busCustomer 客户
     * @return 结果
     */
    @Override
    public int updateBusCustomer(BusCustomer busCustomer)
    {
        return busCustomerMapper.updateBusCustomer(busCustomer);
    }

    /**
     * 批量删除客户
     * 
     * @param ids 需要删除的客户ID
     * @return 结果
     */
    @Override
    public int deleteBusCustomerByIds(Long[] ids)
    {
        return busCustomerMapper.deleteBusCustomerByIds(ids);
    }

    /**
     * 删除客户信息
     * 
     * @param id 客户ID
     * @return 结果
     */
    @Override
    public int deleteBusCustomerById(Long id)
    {
        return busCustomerMapper.deleteBusCustomerById(id);
    }
}
