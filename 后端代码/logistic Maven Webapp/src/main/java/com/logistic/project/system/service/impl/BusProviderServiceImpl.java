package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.project.system.domain.BusProvider;
import com.logistic.project.system.mapper.BusProviderMapper;
import com.logistic.project.system.service.IBusProviderService;

/**
 * 供应商Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-05-05
 */
@Service
public class BusProviderServiceImpl implements IBusProviderService 
{
    @Autowired
    private BusProviderMapper busProviderMapper;

    /**
     * 查询供应商
     * 
     * @param id 供应商ID
     * @return 供应商
     */
    @Override
    public BusProvider selectBusProviderById(Long id)
    {
        return busProviderMapper.selectBusProviderById(id);
    }

    /**
     * 查询供应商列表
     * 
     * @param busProvider 供应商
     * @return 供应商
     */
    @Override
    public List<BusProvider> selectBusProviderList(BusProvider busProvider)
    {
        return busProviderMapper.selectBusProviderList(busProvider);
    }

    /**
     * 新增供应商
     * 
     * @param busProvider 供应商
     * @return 结果
     */
    @Override
    public int insertBusProvider(BusProvider busProvider)
    {
        return busProviderMapper.insertBusProvider(busProvider);
    }

    /**
     * 修改供应商
     * 
     * @param busProvider 供应商
     * @return 结果
     */
    @Override
    public int updateBusProvider(BusProvider busProvider)
    {
        return busProviderMapper.updateBusProvider(busProvider);
    }

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的供应商ID
     * @return 结果
     */
    @Override
    public int deleteBusProviderByIds(Long[] ids)
    {
        return busProviderMapper.deleteBusProviderByIds(ids);
    }

    /**
     * 删除供应商信息
     * 
     * @param id 供应商ID
     * @return 结果
     */
    @Override
    public int deleteBusProviderById(Long id)
    {
        return busProviderMapper.deleteBusProviderById(id);
    }
}
