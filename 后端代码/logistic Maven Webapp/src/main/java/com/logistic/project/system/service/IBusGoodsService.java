package com.logistic.project.system.service;

import java.util.List;

import com.logistic.project.system.domain.BusGoods;

/**
 * 商品Service接口
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月5日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface IBusGoodsService 
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
     * 批量删除商品
     * 
     * @param ids 需要删除的商品ID
     * @return 结果
     */
    public int deleteBusGoodsByIds(Long[] ids);

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    public int deleteBusGoodsById(Long id);
}
