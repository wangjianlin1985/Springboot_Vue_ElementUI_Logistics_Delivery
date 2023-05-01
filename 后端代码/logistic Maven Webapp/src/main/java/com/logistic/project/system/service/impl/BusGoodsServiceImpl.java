package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.project.system.domain.BusGoods;
import com.logistic.project.system.mapper.BusGoodsMapper;
import com.logistic.project.system.service.IBusGoodsService;

/**
 * 商品Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-04-23
 */
@Service
public class BusGoodsServiceImpl implements IBusGoodsService 
{
    @Autowired
    private BusGoodsMapper busGoodsMapper;

    /**
     * 查询商品
     * 
     * @param id 商品ID
     * @return 商品
     */
    @Override
    public BusGoods selectBusGoodsById(Long id)
    {
        return busGoodsMapper.selectBusGoodsById(id);
    }

    /**
     * 查询商品列表
     * 
     * @param busGoods 商品
     * @return 商品
     */
    @Override
    public List<BusGoods> selectBusGoodsList(BusGoods busGoods)
    {
        return busGoodsMapper.selectBusGoodsList(busGoods);
    }

    /**
     * 新增商品
     * 
     * @param busGoods 商品
     * @return 结果
     */
    @Override
    public int insertBusGoods(BusGoods busGoods)
    {
        return busGoodsMapper.insertBusGoods(busGoods);
    }

    /**
     * 修改商品
     * 
     * @param busGoods 商品
     * @return 结果
     */
    @Override
    public int updateBusGoods(BusGoods busGoods)
    {
        return busGoodsMapper.updateBusGoods(busGoods);
    }

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品ID
     * @return 结果
     */
    @Override
    public int deleteBusGoodsByIds(Long[] ids)
    {
        return busGoodsMapper.deleteBusGoodsByIds(ids);
    }

    /**
     * 删除商品信息
     * 
     * @param id 商品ID
     * @return 结果
     */
    @Override
    public int deleteBusGoodsById(Long id)
    {
        return busGoodsMapper.deleteBusGoodsById(id);
    }
}
