package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.project.system.domain.BusInport;
import com.logistic.project.system.mapper.BusInportMapper;
import com.logistic.project.system.service.IBusInportService;

/**
 * 采购管理Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-05-07
 */
@Service
public class BusInportServiceImpl implements IBusInportService 
{
    @Autowired
    private BusInportMapper busInportMapper;

    /**
     * 查询采购管理
     * 
     * @param id 采购管理ID
     * @return 采购管理
     */
    @Override
    public BusInport selectBusInportById(Long id)
    {
        return busInportMapper.selectBusInportById(id);
    }

    /**
     * 查询采购管理列表
     * 
     * @param busInport 采购管理
     * @return 采购管理
     */
    @Override
    public List<BusInport> selectBusInportList(BusInport busInport)
    {
        return busInportMapper.selectBusInportList(busInport);
    }

    /**
     * 新增采购管理
     * 
     * @param busInport 采购管理
     * @return 结果
     */
    @Override
    public int insertBusInport(BusInport busInport)
    {
        return busInportMapper.insertBusInport(busInport);
    }

    /**
     * 修改采购管理
     * 
     * @param busInport 采购管理
     * @return 结果
     */
    @Override
    public int updateBusInport(BusInport busInport)
    {
        return busInportMapper.updateBusInport(busInport);
    }

    /**
     * 批量删除采购管理
     * 
     * @param ids 需要删除的采购管理ID
     * @return 结果
     */
    @Override
    public int deleteBusInportByIds(Long[] ids)
    {
        return busInportMapper.deleteBusInportByIds(ids);
    }

    /**
     * 删除采购管理信息
     * 
     * @param id 采购管理ID
     * @return 结果
     */
    @Override
    public int deleteBusInportById(Long id)
    {
        return busInportMapper.deleteBusInportById(id);
    }
}
