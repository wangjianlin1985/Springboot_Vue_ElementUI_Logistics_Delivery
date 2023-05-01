package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistic.project.system.mapper.BusCustomorderMapper;
import com.logistic.project.system.domain.BusCustomorder;
import com.logistic.project.system.service.IBusCustomorderService;

/**
 * 客户订单查询Service业务层处理
 * 
 * @author mg
 * @date 2020-05-17
 */
@Service
public class BusCustomorderServiceImpl implements IBusCustomorderService 
{
    @Autowired
    private BusCustomorderMapper busCustomorderMapper;

    /**
     * 查询客户订单查询
     * 
     * @param id 客户订单查询ID
     * @return 客户订单查询
     */
    @Override
    public BusCustomorder selectBusCustomorderById(Long id)
    {
        return busCustomorderMapper.selectBusCustomorderById(id);
    }

    /**
     * 查询客户订单查询列表
     * 
     * @param busCustomorder 客户订单查询
     * @return 客户订单查询
     */
    @Override
    public List<BusCustomorder> selectBusCustomorderList(BusCustomorder busCustomorder)
    {
        return busCustomorderMapper.selectBusCustomorderList(busCustomorder);
    }

    /**
     * 新增客户订单查询
     * 
     * @param busCustomorder 客户订单查询
     * @return 结果
     */
    @Override
    public int insertBusCustomorder(BusCustomorder busCustomorder)
    {
        return busCustomorderMapper.insertBusCustomorder(busCustomorder);
    }

    /**
     * 修改客户订单查询
     * 
     * @param busCustomorder 客户订单查询
     * @return 结果
     */
    @Override
    public int updateBusCustomorder(BusCustomorder busCustomorder)
    {
        return busCustomorderMapper.updateBusCustomorder(busCustomorder);
    }

    /**
     * 批量删除客户订单查询
     * 
     * @param ids 需要删除的客户订单查询ID
     * @return 结果
     */
    @Override
    public int deleteBusCustomorderByIds(Long[] ids)
    {
        return busCustomorderMapper.deleteBusCustomorderByIds(ids);
    }

    /**
     * 删除客户订单查询信息
     * 
     * @param id 客户订单查询ID
     * @return 结果
     */
    @Override
    public int deleteBusCustomorderById(Long id)
    {
        return busCustomorderMapper.deleteBusCustomorderById(id);
    }
}
