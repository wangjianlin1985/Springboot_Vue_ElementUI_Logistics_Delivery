package com.logistic.project.system.mapper;

import java.util.List;

import com.logistic.project.system.domain.BusProvider;

/**
 * 供应商Mapper接口
 * 
 * @author nuoyi
 * @date 2020-05-05
 */
public interface BusProviderMapper 
{
    /**
     * 查询供应商
     * 
     * @param id 供应商ID
     * @return 供应商
     */
    public BusProvider selectBusProviderById(Long id);

    /**
     * 查询供应商列表
     * 
     * @param busProvider 供应商
     * @return 供应商集合
     */
    public List<BusProvider> selectBusProviderList(BusProvider busProvider);

    /**
     * 新增供应商
     * 
     * @param busProvider 供应商
     * @return 结果
     */
    public int insertBusProvider(BusProvider busProvider);

    /**
     * 修改供应商
     * 
     * @param busProvider 供应商
     * @return 结果
     */
    public int updateBusProvider(BusProvider busProvider);

    /**
     * 删除供应商
     * 
     * @param id 供应商ID
     * @return 结果
     */
    public int deleteBusProviderById(Long id);

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusProviderByIds(Long[] ids);
}
