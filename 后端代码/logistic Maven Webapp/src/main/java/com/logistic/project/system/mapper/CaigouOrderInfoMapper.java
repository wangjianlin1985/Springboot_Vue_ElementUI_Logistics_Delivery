package com.logistic.project.system.mapper;

import java.util.List;
import com.logistic.project.system.domain.CaigouOrderInfo;

/**
 * 采购物料明细Mapper接口
 * 
 * @author mag
 * @date 2020-05-19
 */
public interface CaigouOrderInfoMapper 
{
    /**
     * 查询采购物料明细
     * 
     * @param id 采购物料明细ID
     * @return 采购物料明细
     */
    public CaigouOrderInfo selectCaigouOrderInfoById(Long id);

    /**
     * 查询采购物料明细列表
     * 
     * @param caigouOrderInfo 采购物料明细
     * @return 采购物料明细集合
     */
    public List<CaigouOrderInfo> selectCaigouOrderInfoList(CaigouOrderInfo caigouOrderInfo);

    /**
     * 新增采购物料明细
     * 
     * @param caigouOrderInfo 采购物料明细
     * @return 结果
     */
    public int insertCaigouOrderInfo(CaigouOrderInfo caigouOrderInfo);

    /**
     * 修改采购物料明细
     * 
     * @param caigouOrderInfo 采购物料明细
     * @return 结果
     */
    public int updateCaigouOrderInfo(CaigouOrderInfo caigouOrderInfo);

    /**
     * 删除采购物料明细
     * 
     * @param id 采购物料明细ID
     * @return 结果
     */
    public int deleteCaigouOrderInfoById(Long id);

    /**
     * 批量删除采购物料明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCaigouOrderInfoByIds(Long[] ids);
}
