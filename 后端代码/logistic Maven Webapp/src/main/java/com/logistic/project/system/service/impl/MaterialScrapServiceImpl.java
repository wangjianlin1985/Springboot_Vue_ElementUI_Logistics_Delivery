package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.project.system.mapper.BusGoodsMapper;
import com.logistic.project.system.mapper.MaterialScrapMapper;
import com.logistic.project.system.domain.BusGoods;
import com.logistic.project.system.domain.MaterialScrap;
import com.logistic.project.system.service.IMaterialScrapService;

/**
 * 物料报废Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-05-13
 */
@Service
public class MaterialScrapServiceImpl implements IMaterialScrapService
{
    @Autowired
    private MaterialScrapMapper materialScrapMapper;
    
    @Autowired
    private BusGoodsMapper busGoodsMapper;
    
    /**
     * 查询物料报废
     * 
     * @param id 物料报废ID
     * @return 物料报废
     */
    @Override
    public MaterialScrap selectMaterialScrapById(Long id)
    {
        
        MaterialScrap ms = materialScrapMapper.selectMaterialScrapById(id);
        return ms;
    }
    
    /**
     * 查询物料报废列表
     * 
     * @param materialScrap 物料报废
     * @return 物料报废
     */
    @Override
    public List<MaterialScrap> selectMaterialScrapList(MaterialScrap materialScrap)
    {
        return materialScrapMapper.selectMaterialScrapList(materialScrap);
    }
    
    /**
     * 新增物料报废
     * 
     * @param materialScrap 物料报废
     * @return 结果
     */
    @Override
    public int insertMaterialScrap(MaterialScrap materialScrap)
    {
        int count = materialScrapMapper.insertMaterialScrap(materialScrap);
        BusGoods busGoods = busGoodsMapper.selectBusGoodsById(materialScrap.getGoodid());
        
        if (busGoods.getNumber() <= materialScrap.getWeight())
        {
            busGoods.setNumber(0L);
        }
        else
        {
            busGoods.setNumber(busGoods.getNumber() - materialScrap.getWeight());
        }
        
        busGoodsMapper.updateBusGoods(busGoods);
        
        return count;
    }
    
    /**
     * 修改物料报废
     * 
     * @param materialScrap 物料报废
     * @return 结果
     */
    @Override
    public int updateMaterialScrap(MaterialScrap materialScrap)
    {
        return materialScrapMapper.updateMaterialScrap(materialScrap);
    }
    
    /**
     * 批量删除物料报废
     * 
     * @param ids 需要删除的物料报废ID
     * @return 结果
     */
    @Override
    public int deleteMaterialScrapByIds(Long[] ids)
    {
        return materialScrapMapper.deleteMaterialScrapByIds(ids);
    }
    
    /**
     * 删除物料报废信息
     * 
     * @param id 物料报废ID
     * @return 结果
     */
    @Override
    public int deleteMaterialScrapById(Long id)
    {
        return materialScrapMapper.deleteMaterialScrapById(id);
    }
}
