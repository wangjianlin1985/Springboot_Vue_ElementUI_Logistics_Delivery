package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistic.project.system.mapper.ShippingdocMapper;
import com.logistic.project.system.domain.Shippingdoc;
import com.logistic.project.system.service.IShippingdocService;

/**
 * 客户单据Service业务层处理
 * 
 * @author mg
 * @date 2020-05-17
 */
@Service
public class ShippingdocServiceImpl implements IShippingdocService 
{
    @Autowired
    private ShippingdocMapper shippingdocMapper;

    /**
     * 查询客户单据
     * 
     * @param id 客户单据ID
     * @return 客户单据
     */
    @Override
    public Shippingdoc selectShippingdocById(Long id)
    {
        return shippingdocMapper.selectShippingdocById(id);
    }

    /**
     * 查询客户单据列表
     * 
     * @param shippingdoc 客户单据
     * @return 客户单据
     */
    @Override
    public List<Shippingdoc> selectShippingdocList(Shippingdoc shippingdoc)
    {
        return shippingdocMapper.selectShippingdocList(shippingdoc);
    }

    /**
     * 新增客户单据
     * 
     * @param shippingdoc 客户单据
     * @return 结果
     */
    @Override
    public int insertShippingdoc(Shippingdoc shippingdoc)
    {
        return shippingdocMapper.insertShippingdoc(shippingdoc);
    }

    /**
     * 修改客户单据
     * 
     * @param shippingdoc 客户单据
     * @return 结果
     */
    @Override
    public int updateShippingdoc(Shippingdoc shippingdoc)
    {
        return shippingdocMapper.updateShippingdoc(shippingdoc);
    }

    /**
     * 批量删除客户单据
     * 
     * @param ids 需要删除的客户单据ID
     * @return 结果
     */
    @Override
    public int deleteShippingdocByIds(Long[] ids)
    {
        return shippingdocMapper.deleteShippingdocByIds(ids);
    }

    /**
     * 删除客户单据信息
     * 
     * @param id 客户单据ID
     * @return 结果
     */
    @Override
    public int deleteShippingdocById(Long id)
    {
        return shippingdocMapper.deleteShippingdocById(id);
    }
}
