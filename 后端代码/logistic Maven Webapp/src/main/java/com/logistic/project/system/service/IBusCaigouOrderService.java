package com.logistic.project.system.service;

import java.util.List;
import com.logistic.project.system.domain.BusCaigouOrder;

/**
 * 采购订单管理Service接口
 * 
 * @author mage
 * @date 2020-05-17
 */
public interface IBusCaigouOrderService 
{
    /**
     * 查询采购订单管理
     * 
     * @param id 采购订单管理ID
     * @return 采购订单管理
     */
    public BusCaigouOrder selectBusCaigouOrderById(Long id);

    /**
     * 查询采购订单管理列表
     * 
     * @param busCaigouOrder 采购订单管理
     * @return 采购订单管理集合
     */
    public List<BusCaigouOrder> selectBusCaigouOrderList(BusCaigouOrder busCaigouOrder);

    /**
     * 新增采购订单管理
     * 
     * @param busCaigouOrder 采购订单管理
     * @return 结果
     */
    public int insertBusCaigouOrder(BusCaigouOrder busCaigouOrder);

    /**
     * 修改采购订单管理
     * 
     * @param busCaigouOrder 采购订单管理
     * @return 结果
     */
    public int updateBusCaigouOrder(BusCaigouOrder busCaigouOrder);

    /**
     * 批量删除采购订单管理
     * 
     * @param ids 需要删除的采购订单管理ID
     * @return 结果
     */
    public int deleteBusCaigouOrderByIds(Long[] ids);

    /**
     * 删除采购订单管理信息
     * 
     * @param id 采购订单管理ID
     * @return 结果
     */
    public int deleteBusCaigouOrderById(Long id);
}
