package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistic.project.system.mapper.BusCaigouOrderMapper;
import com.logistic.project.system.domain.BusCaigouOrder;
import com.logistic.project.system.service.IBusCaigouOrderService;

/**
 * 采购订单管理Service业务层处理
 * 
 * @author mage
 * @date 2020-05-17
 */
@Service
public class BusCaigouOrderServiceImpl implements IBusCaigouOrderService 
{
    @Autowired
    private BusCaigouOrderMapper busCaigouOrderMapper;

    /**
     * 查询采购订单管理
     * 
     * @param id 采购订单管理ID
     * @return 采购订单管理
     */
    @Override
    public BusCaigouOrder selectBusCaigouOrderById(Long id)
    {
        return busCaigouOrderMapper.selectBusCaigouOrderById(id);
    }

    /**
     * 查询采购订单管理列表
     * 
     * @param busCaigouOrder 采购订单管理
     * @return 采购订单管理
     */
    @Override
    public List<BusCaigouOrder> selectBusCaigouOrderList(BusCaigouOrder busCaigouOrder)
    {
        return busCaigouOrderMapper.selectBusCaigouOrderList(busCaigouOrder);
    }

    /**
     * 新增采购订单管理
     * 
     * @param busCaigouOrder 采购订单管理
     * @return 结果
     */
    @Override
    public int insertBusCaigouOrder(BusCaigouOrder busCaigouOrder)
    {
        return busCaigouOrderMapper.insertBusCaigouOrder(busCaigouOrder);
    }

    /**
     * 修改采购订单管理
     * 
     * @param busCaigouOrder 采购订单管理
     * @return 结果
     */
    @Override
    public int updateBusCaigouOrder(BusCaigouOrder busCaigouOrder)
    {
        return busCaigouOrderMapper.updateBusCaigouOrder(busCaigouOrder);
    }

    /**
     * 批量删除采购订单管理
     * 
     * @param ids 需要删除的采购订单管理ID
     * @return 结果
     */
    @Override
    public int deleteBusCaigouOrderByIds(Long[] ids)
    {
        return busCaigouOrderMapper.deleteBusCaigouOrderByIds(ids);
    }

    /**
     * 删除采购订单管理信息
     * 
     * @param id 采购订单管理ID
     * @return 结果
     */
    @Override
    public int deleteBusCaigouOrderById(Long id)
    {
        return busCaigouOrderMapper.deleteBusCaigouOrderById(id);
    }
}
