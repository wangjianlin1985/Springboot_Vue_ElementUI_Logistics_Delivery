package com.logistic.project.system.service;

import java.util.List;
import com.logistic.project.system.domain.BusPurchase;

/**
 * 采购申请Service接口
 * 
 * @author mg
 * @date 2020-05-17
 */
public interface IBusPurchaseService 
{
    /**
     * 查询采购申请
     * 
     * @param id 采购申请ID
     * @return 采购申请
     */
    public BusPurchase selectBusPurchaseById(Long id);

    /**
     * 查询采购申请列表
     * 
     * @param busPurchase 采购申请
     * @return 采购申请集合
     */
    public List<BusPurchase> selectBusPurchaseList(BusPurchase busPurchase);

    /**
     * 新增采购申请
     * 
     * @param busPurchase 采购申请
     * @return 结果
     */
    public int insertBusPurchase(BusPurchase busPurchase);

    /**
     * 修改采购申请
     * 
     * @param busPurchase 采购申请
     * @return 结果
     */
    public int updateBusPurchase(BusPurchase busPurchase);

    /**
     * 批量删除采购申请
     * 
     * @param ids 需要删除的采购申请ID
     * @return 结果
     */
    public int deleteBusPurchaseByIds(Long[] ids);

    /**
     * 删除采购申请信息
     * 
     * @param id 采购申请ID
     * @return 结果
     */
    public int deleteBusPurchaseById(Long id);
}
