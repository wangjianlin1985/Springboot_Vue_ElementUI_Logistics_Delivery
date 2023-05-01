package com.logistic.project.system.service;

import java.util.List;

import com.logistic.project.system.domain.BusDelivery;

/**
 * 配送运输Service接口
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface IBusDeliveryService 
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
     * 批量删除配送运输
     * 
     * @param ids 需要删除的配送运输ID
     * @return 结果
     */
    public int deleteBusDeliveryByIds(Long[] ids);

    /**
     * 删除配送运输信息
     * 
     * @param id 配送运输ID
     * @return 结果
     */
    public int deleteBusDeliveryById(Long id);
}
