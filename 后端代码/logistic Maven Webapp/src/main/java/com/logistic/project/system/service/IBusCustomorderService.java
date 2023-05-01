package com.logistic.project.system.service;

import java.util.List;
import com.logistic.project.system.domain.BusCustomorder;

/**
 * 客户订单查询Service接口
 * 
 * @author mg
 * @date 2020-05-17
 */
public interface IBusCustomorderService 
{
    /**
     * 查询客户订单查询
     * 
     * @param id 客户订单查询ID
     * @return 客户订单查询
     */
    public BusCustomorder selectBusCustomorderById(Long id);

    /**
     * 查询客户订单查询列表
     * 
     * @param busCustomorder 客户订单查询
     * @return 客户订单查询集合
     */
    public List<BusCustomorder> selectBusCustomorderList(BusCustomorder busCustomorder);

    /**
     * 新增客户订单查询
     * 
     * @param busCustomorder 客户订单查询
     * @return 结果
     */
    public int insertBusCustomorder(BusCustomorder busCustomorder);

    /**
     * 修改客户订单查询
     * 
     * @param busCustomorder 客户订单查询
     * @return 结果
     */
    public int updateBusCustomorder(BusCustomorder busCustomorder);

    /**
     * 批量删除客户订单查询
     * 
     * @param ids 需要删除的客户订单查询ID
     * @return 结果
     */
    public int deleteBusCustomorderByIds(Long[] ids);

    /**
     * 删除客户订单查询信息
     * 
     * @param id 客户订单查询ID
     * @return 结果
     */
    public int deleteBusCustomorderById(Long id);
}
