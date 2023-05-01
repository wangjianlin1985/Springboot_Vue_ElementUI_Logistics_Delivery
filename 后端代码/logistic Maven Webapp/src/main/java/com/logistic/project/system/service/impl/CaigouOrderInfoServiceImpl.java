package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistic.project.system.mapper.CaigouOrderInfoMapper;
import com.logistic.project.system.domain.CaigouOrderInfo;
import com.logistic.project.system.service.ICaigouOrderInfoService;

/**
 * 采购物料明细Service业务层处理
 * 
 * @author mag
 * @date 2020-05-19
 */
@Service
public class CaigouOrderInfoServiceImpl implements ICaigouOrderInfoService 
{
    @Autowired
    private CaigouOrderInfoMapper caigouOrderInfoMapper;

    /**
     * 查询采购物料明细
     * 
     * @param id 采购物料明细ID
     * @return 采购物料明细
     */
    @Override
    public CaigouOrderInfo selectCaigouOrderInfoById(Long id)
    {
        return caigouOrderInfoMapper.selectCaigouOrderInfoById(id);
    }

    /**
     * 查询采购物料明细列表
     * 
     * @param caigouOrderInfo 采购物料明细
     * @return 采购物料明细
     */
    @Override
    public List<CaigouOrderInfo> selectCaigouOrderInfoList(CaigouOrderInfo caigouOrderInfo)
    {
        return caigouOrderInfoMapper.selectCaigouOrderInfoList(caigouOrderInfo);
    }

    /**
     * 新增采购物料明细
     * 
     * @param caigouOrderInfo 采购物料明细
     * @return 结果
     */
    @Override
    public int insertCaigouOrderInfo(CaigouOrderInfo caigouOrderInfo)
    {
        return caigouOrderInfoMapper.insertCaigouOrderInfo(caigouOrderInfo);
    }

    /**
     * 修改采购物料明细
     * 
     * @param caigouOrderInfo 采购物料明细
     * @return 结果
     */
    @Override
    public int updateCaigouOrderInfo(CaigouOrderInfo caigouOrderInfo)
    {
        return caigouOrderInfoMapper.updateCaigouOrderInfo(caigouOrderInfo);
    }

    /**
     * 批量删除采购物料明细
     * 
     * @param ids 需要删除的采购物料明细ID
     * @return 结果
     */
    @Override
    public int deleteCaigouOrderInfoByIds(Long[] ids)
    {
        return caigouOrderInfoMapper.deleteCaigouOrderInfoByIds(ids);
    }

    /**
     * 删除采购物料明细信息
     * 
     * @param id 采购物料明细ID
     * @return 结果
     */
    @Override
    public int deleteCaigouOrderInfoById(Long id)
    {
        return caigouOrderInfoMapper.deleteCaigouOrderInfoById(id);
    }
}
