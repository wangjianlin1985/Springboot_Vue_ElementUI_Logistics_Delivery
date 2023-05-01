package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistic.project.system.mapper.BusRukuMapper;
import com.logistic.project.system.domain.BusRuku;
import com.logistic.project.system.service.IBusRukuService;

/**
 * 入库接单Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-05-17
 */
@Service
public class BusRukuServiceImpl implements IBusRukuService 
{
    @Autowired
    private BusRukuMapper busRukuMapper;

    /**
     * 查询入库接单
     * 
     * @param id 入库接单ID
     * @return 入库接单
     */
    @Override
    public BusRuku selectBusRukuById(Long id)
    {
        return busRukuMapper.selectBusRukuById(id);
    }

    /**
     * 查询入库接单列表
     * 
     * @param busRuku 入库接单
     * @return 入库接单
     */
    @Override
    public List<BusRuku> selectBusRukuList(BusRuku busRuku)
    {
        return busRukuMapper.selectBusRukuList(busRuku);
    }

    /**
     * 新增入库接单
     * 
     * @param busRuku 入库接单
     * @return 结果
     */
    @Override
    public int insertBusRuku(BusRuku busRuku)
    {
        return busRukuMapper.insertBusRuku(busRuku);
    }

    /**
     * 修改入库接单
     * 
     * @param busRuku 入库接单
     * @return 结果
     */
    @Override
    public int updateBusRuku(BusRuku busRuku)
    {
        return busRukuMapper.updateBusRuku(busRuku);
    }

    /**
     * 批量删除入库接单
     * 
     * @param ids 需要删除的入库接单ID
     * @return 结果
     */
    @Override
    public int deleteBusRukuByIds(Long[] ids)
    {
        return busRukuMapper.deleteBusRukuByIds(ids);
    }

    /**
     * 删除入库接单信息
     * 
     * @param id 入库接单ID
     * @return 结果
     */
    @Override
    public int deleteBusRukuById(Long id)
    {
        return busRukuMapper.deleteBusRukuById(id);
    }
}
