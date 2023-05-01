package com.logistic.project.system.mapper;

import java.util.List;

import com.logistic.project.system.domain.BusDelivery;

/**
 * 配送运输Mapper接口
 * 
 * @author nuoyi
 * @date 2020-05-07
 */
public interface BusDeliveryMapper 
{
    /**
     * 查询配送运输
     * 
     * @param id 配送运输ID
     * @return 配送运输
     */
    public BusDelivery selectBusDeliveryById(Long id);

    /**
     * 查询配送运输列表
     * 
     * @param busDelivery 配送运输
     * @return 配送运输集合
     */
    public List<BusDelivery> selectBusDeliveryList(BusDelivery busDelivery);

    /**
     * 新增配送运输
     * 
     * @param busDelivery 配送运输
     * @return 结果
     */
    public int insertBusDelivery(BusDelivery busDelivery);

    /**
     * 修改配送运输
     * 
     * @param busDelivery 配送运输
     * @return 结果
     */
    public int updateBusDelivery(BusDelivery busDelivery);

    /**
     * 删除配送运输
     * 
     * @param id 配送运输ID
     * @return 结果
     */
    public int deleteBusDeliveryById(Long id);

    /**
     * 批量删除配送运输
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusDeliveryByIds(Long[] ids);
}
