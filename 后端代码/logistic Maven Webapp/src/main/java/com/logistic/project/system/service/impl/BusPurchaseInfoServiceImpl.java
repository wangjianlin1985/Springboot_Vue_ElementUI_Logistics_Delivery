package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistic.project.system.mapper.BusPurchaseInfoMapper;
import com.logistic.project.system.domain.BusPurchaseInfo;
import com.logistic.project.system.service.IBusPurchaseInfoService;

/**
 * 申请物料明细Service业务层处理
 * 
 * @author mg
 * @date 2020-05-18
 */
@Service
public class BusPurchaseInfoServiceImpl implements IBusPurchaseInfoService 
{
    @Autowired
    private BusPurchaseInfoMapper busPurchaseInfoMapper;

    /**
     * 查询申请物料明细
     * 
     * @param id 申请物料明细ID
     * @return 申请物料明细
     */
    @Override
    public BusPurchaseInfo selectBusPurchaseInfoById(Long id)
    {
        return busPurchaseInfoMapper.selectBusPurchaseInfoById(id);
    }

    /**
     * 查询申请物料明细列表
     * 
     * @param busPurchaseInfo 申请物料明细
     * @return 申请物料明细
     */
    @Override
    public List<BusPurchaseInfo> selectBusPurchaseInfoList(BusPurchaseInfo busPurchaseInfo)
    {
        return busPurchaseInfoMapper.selectBusPurchaseInfoList(busPurchaseInfo);
    }

    /**
     * 新增申请物料明细
     * 
     * @param busPurchaseInfo 申请物料明细
     * @return 结果
     */
    @Override
    public int insertBusPurchaseInfo(BusPurchaseInfo busPurchaseInfo)
    {
        return busPurchaseInfoMapper.insertBusPurchaseInfo(busPurchaseInfo);
    }

    /**
     * 修改申请物料明细
     * 
     * @param busPurchaseInfo 申请物料明细
     * @return 结果
     */
    @Override
    public int updateBusPurchaseInfo(BusPurchaseInfo busPurchaseInfo)
    {
        return busPurchaseInfoMapper.updateBusPurchaseInfo(busPurchaseInfo);
    }

    /**
     * 批量删除申请物料明细
     * 
     * @param ids 需要删除的申请物料明细ID
     * @return 结果
     */
    @Override
    public int deleteBusPurchaseInfoByIds(Long[] ids)
    {
        return busPurchaseInfoMapper.deleteBusPurchaseInfoByIds(ids);
    }

    /**
     * 删除申请物料明细信息
     * 
     * @param id 申请物料明细ID
     * @return 结果
     */
    @Override
    public int deleteBusPurchaseInfoById(Long id)
    {
        return busPurchaseInfoMapper.deleteBusPurchaseInfoById(id);
    }
}
