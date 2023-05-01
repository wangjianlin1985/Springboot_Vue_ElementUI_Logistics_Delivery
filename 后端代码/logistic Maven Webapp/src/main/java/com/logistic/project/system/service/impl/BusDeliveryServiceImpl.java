package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.project.system.domain.BusDelivery;
import com.logistic.project.system.mapper.BusDeliveryMapper;
import com.logistic.project.system.service.IBusDeliveryService;

/**
 * 配送运输Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-05-07
 */
@Service
public class BusDeliveryServiceImpl implements IBusDeliveryService 
{
    @Autowired
    private BusDeliveryMapper busDeliveryMapper;

    /**
     * 查询配送运输
     * 
     * @param id 配送运输ID
     * @return 配送运输
     */
    @Override
    public BusDelivery selectBusDeliveryById(Long id)
    {
        return busDeliveryMapper.selectBusDeliveryById(id);
    }

    /**
     * 查询配送运输列表
     * 
     * @param busDelivery 配送运输
     * @return 配送运输
     */
    @Override
    public List<BusDelivery> selectBusDeliveryList(BusDelivery busDelivery)
    {
        return busDeliveryMapper.selectBusDeliveryList(busDelivery);
    }

    /**
     * 新增配送运输
     * 
     * @param busDelivery 配送运输
     * @return 结果
     */
    @Override
    public int insertBusDelivery(BusDelivery busDelivery)
    {
        return busDeliveryMapper.insertBusDelivery(busDelivery);
    }

    /**
     * 修改配送运输
     * 
     * @param busDelivery 配送运输
     * @return 结果
     */
    @Override
    public int updateBusDelivery(BusDelivery busDelivery)
    {
        return busDeliveryMapper.updateBusDelivery(busDelivery);
    }

    /**
     * 批量删除配送运输
     * 
     * @param ids 需要删除的配送运输ID
     * @return 结果
     */
    @Override
    public int deleteBusDeliveryByIds(Long[] ids)
    {
        return busDeliveryMapper.deleteBusDeliveryByIds(ids);
    }

    /**
     * 删除配送运输信息
     * 
     * @param id 配送运输ID
     * @return 结果
     */
    @Override
    public int deleteBusDeliveryById(Long id)
    {
        return busDeliveryMapper.deleteBusDeliveryById(id);
    }
}
