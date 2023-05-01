package com.logistic.project.system.mapper;

import java.util.List;
import com.logistic.project.system.domain.Shippingdoc;

/**
 * 客户单据Mapper接口
 * 
 * @author mg
 * @date 2020-05-17
 */
public interface ShippingdocMapper 
{
    /**
     * 查询客户单据
     * 
     * @param id 客户单据ID
     * @return 客户单据
     */
    public Shippingdoc selectShippingdocById(Long id);

    /**
     * 查询客户单据列表
     * 
     * @param shippingdoc 客户单据
     * @return 客户单据集合
     */
    public List<Shippingdoc> selectShippingdocList(Shippingdoc shippingdoc);

    /**
     * 新增客户单据
     * 
     * @param shippingdoc 客户单据
     * @return 结果
     */
    public int insertShippingdoc(Shippingdoc shippingdoc);

    /**
     * 修改客户单据
     * 
     * @param shippingdoc 客户单据
     * @return 结果
     */
    public int updateShippingdoc(Shippingdoc shippingdoc);

    /**
     * 删除客户单据
     * 
     * @param id 客户单据ID
     * @return 结果
     */
    public int deleteShippingdocById(Long id);

    /**
     * 批量删除客户单据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShippingdocByIds(Long[] ids);
}
