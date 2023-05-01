package com.logistic.project.system.service;

import java.util.List;

import com.logistic.project.system.domain.BusInport;

/**
 * 采购管理Service接口
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface IBusInportService 
{
    /**
     * 查询采购管理
     * 
     * @param id 采购管理ID
     * @return 采购管理
     */
    public BusInport selectBusInportById(Long id);

    /**
     * 查询采购管理列表
     * 
     * @param busInport 采购管理
     * @return 采购管理集合
     */
    public List<BusInport> selectBusInportList(BusInport busInport);

    /**
     * 新增采购管理
     * 
     * @param busInport 采购管理
     * @return 结果
     */
    public int insertBusInport(BusInport busInport);

    /**
     * 修改采购管理
     * 
     * @param busInport 采购管理
     * @return 结果
     */
    public int updateBusInport(BusInport busInport);

    /**
     * 批量删除采购管理
     * 
     * @param ids 需要删除的采购管理ID
     * @return 结果
     */
    public int deleteBusInportByIds(Long[] ids);

    /**
     * 删除采购管理信息
     * 
     * @param id 采购管理ID
     * @return 结果
     */
    public int deleteBusInportById(Long id);
}
