package com.logistic.project.system.mapper;

import java.util.List;

import com.logistic.project.system.domain.BusOutport;

/**
 * 出库管理Mapper接口
 * 
 * @author nuoyi
 * @date 2020-05-07
 */
public interface BusOutportMapper 
{
    /**
     * 查询出库管理
     * 
     * @param id 出库管理ID
     * @return 出库管理
     */
    public BusOutport selectBusOutportById(Long id);

    /**
     * 查询出库管理列表
     * 
     * @param busOutport 出库管理
     * @return 出库管理集合
     */
    public List<BusOutport> selectBusOutportList(BusOutport busOutport);

    /**
     * 新增出库管理
     * 
     * @param busOutport 出库管理
     * @return 结果
     */
    public int insertBusOutport(BusOutport busOutport);

    /**
     * 修改出库管理
     * 
     * @param busOutport 出库管理
     * @return 结果
     */
    public int updateBusOutport(BusOutport busOutport);

    /**
     * 删除出库管理
     * 
     * @param id 出库管理ID
     * @return 结果
     */
    public int deleteBusOutportById(Long id);

    /**
     * 批量删除出库管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusOutportByIds(Long[] ids);
}
