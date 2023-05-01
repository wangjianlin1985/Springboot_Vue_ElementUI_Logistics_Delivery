package com.logistic.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logistic.project.system.mapper.BusCkCheckMapper;
import com.logistic.project.system.domain.BusCkCheck;
import com.logistic.project.system.service.IBusCkCheckService;

/**
 * 仓库检查Service业务层处理
 * 
 * @author nuoyi
 * @date 2020-05-17
 */
@Service
public class BusCkCheckServiceImpl implements IBusCkCheckService 
{
    @Autowired
    private BusCkCheckMapper busCkCheckMapper;

    /**
     * 查询仓库检查
     * 
     * @param id 仓库检查ID
     * @return 仓库检查
     */
    @Override
    public BusCkCheck selectBusCkCheckById(Long id)
    {
        return busCkCheckMapper.selectBusCkCheckById(id);
    }

    /**
     * 查询仓库检查列表
     * 
     * @param busCkCheck 仓库检查
     * @return 仓库检查
     */
    @Override
    public List<BusCkCheck> selectBusCkCheckList(BusCkCheck busCkCheck)
    {
        return busCkCheckMapper.selectBusCkCheckList(busCkCheck);
    }

    /**
     * 新增仓库检查
     * 
     * @param busCkCheck 仓库检查
     * @return 结果
     */
    @Override
    public int insertBusCkCheck(BusCkCheck busCkCheck)
    {
        return busCkCheckMapper.insertBusCkCheck(busCkCheck);
    }

    /**
     * 修改仓库检查
     * 
     * @param busCkCheck 仓库检查
     * @return 结果
     */
    @Override
    public int updateBusCkCheck(BusCkCheck busCkCheck)
    {
        return busCkCheckMapper.updateBusCkCheck(busCkCheck);
    }

    /**
     * 批量删除仓库检查
     * 
     * @param ids 需要删除的仓库检查ID
     * @return 结果
     */
    @Override
    public int deleteBusCkCheckByIds(Long[] ids)
    {
        return busCkCheckMapper.deleteBusCkCheckByIds(ids);
    }

    /**
     * 删除仓库检查信息
     * 
     * @param id 仓库检查ID
     * @return 结果
     */
    @Override
    public int deleteBusCkCheckById(Long id)
    {
        return busCkCheckMapper.deleteBusCkCheckById(id);
    }
}
