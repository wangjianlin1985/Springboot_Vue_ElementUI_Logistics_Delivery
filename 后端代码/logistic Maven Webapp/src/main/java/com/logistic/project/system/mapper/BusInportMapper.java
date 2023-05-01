package com.logistic.project.system.mapper;

import java.util.List;

import com.logistic.project.system.domain.BusInport;

/**
 * 采购管理Mapper接口
 * 
 * @author nuoyi
 * @date 2020-05-07
 */
public interface BusInportMapper 
{
    /**
     * 查询采购管理
     * 
     * @param id 采购管理ID
     * @return 采购管理
     */
    public BusInport selectBusInportById(Long id);

    /**
     * 查询采购管理列表
     * 
     * @param busInport 采购管理
     * @return 采购管理集合
     */
    public List<BusInport> selectBusInportList(BusInport busInport);

    /**
     * 新增采购管理
     * 
     * @param busInport 采购管理
     * @return 结果
     */
    public int insertBusInport(BusInport busInport);

    /**
     * 修改采购管理
     * 
     * @param busInport 采购管理
     * @return 结果
     */
    public int updateBusInport(BusInport busInport);

    /**
     * 删除采购管理
     * 
     * @param id 采购管理ID
     * @return 结果
     */
    public int deleteBusInportById(Long id);

    /**
     * 批量删除采购管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusInportByIds(Long[] ids);
}
