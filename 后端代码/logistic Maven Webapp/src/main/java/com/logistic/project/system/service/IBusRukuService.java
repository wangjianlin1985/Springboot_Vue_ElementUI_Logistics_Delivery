package com.logistic.project.system.service;

import java.util.List;
import com.logistic.project.system.domain.BusRuku;

/**
 * 入库接单Service接口
 * 
 * @author nuoyi
 * @date 2020-05-17
 */
public interface IBusRukuService 
{
    /**
     * 查询入库接单
     * 
     * @param id 入库接单ID
     * @return 入库接单
     */
    public BusRuku selectBusRukuById(Long id);

    /**
     * 查询入库接单列表
     * 
     * @param busRuku 入库接单
     * @return 入库接单集合
     */
    public List<BusRuku> selectBusRukuList(BusRuku busRuku);

    /**
     * 新增入库接单
     * 
     * @param busRuku 入库接单
     * @return 结果
     */
    public int insertBusRuku(BusRuku busRuku);

    /**
     * 修改入库接单
     * 
     * @param busRuku 入库接单
     * @return 结果
     */
    public int updateBusRuku(BusRuku busRuku);

    /**
     * 批量删除入库接单
     * 
     * @param ids 需要删除的入库接单ID
     * @return 结果
     */
    public int deleteBusRukuByIds(Long[] ids);

    /**
     * 删除入库接单信息
     * 
     * @param id 入库接单ID
     * @return 结果
     */
    public int deleteBusRukuById(Long id);
}
