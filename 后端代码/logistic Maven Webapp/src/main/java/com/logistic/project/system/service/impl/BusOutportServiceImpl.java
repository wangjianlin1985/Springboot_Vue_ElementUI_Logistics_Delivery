package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.project.system.domain.BusOutport;
import com.logistic.project.system.mapper.BusOutportMapper;
import com.logistic.project.system.service.IBusOutportService;

/**
 * 出库管理Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-05-07
 */
@Service
public class BusOutportServiceImpl implements IBusOutportService 
{
    @Autowired
    private BusOutportMapper busOutportMapper;

    /**
     * 查询出库管理
     * 
     * @param id 出库管理ID
     * @return 出库管理
     */
    @Override
    public BusOutport selectBusOutportById(Long id)
    {
        return busOutportMapper.selectBusOutportById(id);
    }

    /**
     * 查询出库管理列表
     * 
     * @param busOutport 出库管理
     * @return 出库管理
     */
    @Override
    public List<BusOutport> selectBusOutportList(BusOutport busOutport)
    {
        return busOutportMapper.selectBusOutportList(busOutport);
    }

    /**
     * 新增出库管理
     * 
     * @param busOutport 出库管理
     * @return 结果
     */
    @Override
    public int insertBusOutport(BusOutport busOutport)
    {
        return busOutportMapper.insertBusOutport(busOutport);
    }

    /**
     * 修改出库管理
     * 
     * @param busOutport 出库管理
     * @return 结果
     */
    @Override
    public int updateBusOutport(BusOutport busOutport)
    {
        return busOutportMapper.updateBusOutport(busOutport);
    }

    /**
     * 批量删除出库管理
     * 
     * @param ids 需要删除的出库管理ID
     * @return 结果
     */
    @Override
    public int deleteBusOutportByIds(Long[] ids)
    {
        return busOutportMapper.deleteBusOutportByIds(ids);
    }

    /**
     * 删除出库管理信息
     * 
     * @param id 出库管理ID
     * @return 结果
     */
    @Override
    public int deleteBusOutportById(Long id)
    {
        return busOutportMapper.deleteBusOutportById(id);
    }
}
