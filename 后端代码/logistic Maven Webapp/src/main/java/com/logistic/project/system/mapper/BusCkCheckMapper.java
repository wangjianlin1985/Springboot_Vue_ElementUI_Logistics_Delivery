package com.logistic.project.system.mapper;

import java.util.List;
import com.logistic.project.system.domain.BusCkCheck;

/**
 * 仓库检查Mapper接口
 * 
 * @author nuoyi
 * @date 2020-05-17
 */
public interface BusCkCheckMapper 
{
    /**
     * 查询仓库检查
     * 
     * @param id 仓库检查ID
     * @return 仓库检查
     */
    public BusCkCheck selectBusCkCheckById(Long id);

    /**
     * 查询仓库检查列表
     * 
     * @param busCkCheck 仓库检查
     * @return 仓库检查集合
     */
    public List<BusCkCheck> selectBusCkCheckList(BusCkCheck busCkCheck);

    /**
     * 新增仓库检查
     * 
     * @param busCkCheck 仓库检查
     * @return 结果
     */
    public int insertBusCkCheck(BusCkCheck busCkCheck);

    /**
     * 修改仓库检查
     * 
     * @param busCkCheck 仓库检查
     * @return 结果
     */
    public int updateBusCkCheck(BusCkCheck busCkCheck);

    /**
     * 删除仓库检查
     * 
     * @param id 仓库检查ID
     * @return 结果
     */
    public int deleteBusCkCheckById(Long id);

    /**
     * 批量删除仓库检查
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusCkCheckByIds(Long[] ids);
}
