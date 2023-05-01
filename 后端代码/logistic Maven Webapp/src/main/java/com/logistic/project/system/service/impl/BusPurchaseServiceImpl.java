package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistic.project.system.mapper.BusPurchaseMapper;
import com.logistic.project.system.domain.BusPurchase;
import com.logistic.project.system.service.IBusPurchaseService;

/**
 * 采购申请Service业务层处理
 * 
 * @author mg
 * @date 2020-05-17
 */
@Service
public class BusPurchaseServiceImpl implements IBusPurchaseService 
{
    @Autowired
    private BusPurchaseMapper busPurchaseMapper;

    /**
     * 查询采购申请
     * 
     * @param id 采购申请ID
     * @return 采购申请
     */
    @Override
    public BusPurchase selectBusPurchaseById(Long id)
    {
        return busPurchaseMapper.selectBusPurchaseById(id);
    }

    /**
     * 查询采购申请列表
     * 
     * @param busPurchase 采购申请
     * @return 采购申请
     */
    @Override
    public List<BusPurchase> selectBusPurchaseList(BusPurchase busPurchase)
    {
        return busPurchaseMapper.selectBusPurchaseList(busPurchase);
    }

    /**
     * 新增采购申请
     * 
     * @param busPurchase 采购申请
     * @return 结果
     */
    @Override
    public int insertBusPurchase(BusPurchase busPurchase)
    {
        return busPurchaseMapper.insertBusPurchase(busPurchase);
    }

    /**
     * 修改采购申请
     * 
     * @param busPurchase 采购申请
     * @return 结果
     */
    @Override
    public int updateBusPurchase(BusPurchase busPurchase)
    {
        return busPurchaseMapper.updateBusPurchase(busPurchase);
    }

    /**
     * 批量删除采购申请
     * 
     * @param ids 需要删除的采购申请ID
     * @return 结果
     */
    @Override
    public int deleteBusPurchaseByIds(Long[] ids)
    {
        return busPurchaseMapper.deleteBusPurchaseByIds(ids);
    }

    /**
     * 删除采购申请信息
     * 
     * @param id 采购申请ID
     * @return 结果
     */
    @Override
    public int deleteBusPurchaseById(Long id)
    {
        return busPurchaseMapper.deleteBusPurchaseById(id);
    }
}
