package com.logistic.project.system.mapper;

import java.util.List;
import com.logistic.project.system.domain.BusPurchaseInfo;

/**
 * 申请物料明细Mapper接口
 * 
 * @author mg
 * @date 2020-05-18
 */
public interface BusPurchaseInfoMapper 
{
    /**
     * 查询申请物料明细
     * 
     * @param id 申请物料明细ID
     * @return 申请物料明细
     */
    public BusPurchaseInfo selectBusPurchaseInfoById(Long id);

    /**
     * 查询申请物料明细列表
     * 
     * @param busPurchaseInfo 申请物料明细
     * @return 申请物料明细集合
     */
    public List<BusPurchaseInfo> selectBusPurchaseInfoList(BusPurchaseInfo busPurchaseInfo);

    /**
     * 新增申请物料明细
     * 
     * @param busPurchaseInfo 申请物料明细
     * @return 结果
     */
    public int insertBusPurchaseInfo(BusPurchaseInfo busPurchaseInfo);

    /**
     * 修改申请物料明细
     * 
     * @param busPurchaseInfo 申请物料明细
     * @return 结果
     */
    public int updateBusPurchaseInfo(BusPurchaseInfo busPurchaseInfo);

    /**
     * 删除申请物料明细
     * 
     * @param id 申请物料明细ID
     * @return 结果
     */
    public int deleteBusPurchaseInfoById(Long id);

    /**
     * 批量删除申请物料明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusPurchaseInfoByIds(Long[] ids);
}
