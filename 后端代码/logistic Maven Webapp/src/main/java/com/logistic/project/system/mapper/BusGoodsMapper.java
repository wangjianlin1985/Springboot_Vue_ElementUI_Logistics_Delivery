package com.logistic.project.system.mapper;

import java.util.List;

import com.logistic.project.system.domain.BusGoods;

/**
 * 商品Mapper接口
 * 
 * @author nuoyi
 * @date 2020-04-23
 */
public interface BusGoodsMapper 
{
    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    public BusGoods selectBusGoodsById(Long id);

    /**
     * 查询商品列表
     * 
     * @param busGoods 商品
     * @return 商品集合
     */
    public List<BusGoods> selectBusGoodsList(BusGoods busGoods);

    /**
     * 新增商品
     * 
     * @param busGoods 商品
     * @return 结果
     */
    public int insertBusGoods(BusGoods busGoods);

    /**
     * 修改商品
     * 
     * @param busGoods 商品
     * @return 结果
     */
    public int updateBusGoods(BusGoods busGoods);

    /**
     * 删除商品
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteBusGoodsById(Long id);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusGoodsByIds(Long[] ids);
}
