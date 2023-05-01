package com.logistic.project.system.service;

import java.util.List;
import com.logistic.project.system.domain.MaterialScrap;

/**
 * 物料报废Service接口
 * 
 * @author nuoyi
 * @date 2020-05-13
 */
public interface IMaterialScrapService 
{
    /**
     * 查询物料报废
     * 
     * @param id 物料报废ID
     * @return 物料报废
     */
    public MaterialScrap selectMaterialScrapById(Long id);

    /**
     * 查询物料报废列表
     * 
     * @param materialScrap 物料报废
     * @return 物料报废集合
     */
    public List<MaterialScrap> selectMaterialScrapList(MaterialScrap materialScrap);

    /**
     * 新增物料报废
     * 
     * @param materialScrap 物料报废
     * @return 结果
     */
    public int insertMaterialScrap(MaterialScrap materialScrap);

    /**
     * 修改物料报废
     * 
     * @param materialScrap 物料报废
     * @return 结果
     */
    public int updateMaterialScrap(MaterialScrap materialScrap);

    /**
     * 批量删除物料报废
     * 
     * @param ids 需要删除的物料报废ID
     * @return 结果
     */
    public int deleteMaterialScrapByIds(Long[] ids);

    /**
     * 删除物料报废信息
     * 
     * @param id 物料报废ID
     * @return 结果
     */
    public int deleteMaterialScrapById(Long id);
}
