package com.logistic.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.logistic.framework.aspectj.lang.annotation.Log;
import com.logistic.framework.aspectj.lang.enums.BusinessType;
import com.logistic.project.system.domain.BusGoods;
import com.logistic.project.system.domain.MaterialScrap;
import com.logistic.project.system.service.IBusGoodsService;
import com.logistic.project.system.service.IMaterialScrapService;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.web.page.TableDataInfo;

/**
 * 物料报废Controller <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2020年5月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
@RequestMapping("/system/scrap")
public class MaterialScrapController extends BaseController
{
    @Autowired
    private IMaterialScrapService materialScrapService;
    
    @Autowired
    private IBusGoodsService busGoodsService;
    
    /**
     * 查询物料报废列表
     */
    @PreAuthorize("@ss.hasPermi('system:scrap:list')")
    @GetMapping("/list")
    public TableDataInfo list(MaterialScrap materialScrap)
    {
        startPage();
        List<MaterialScrap> list = materialScrapService.selectMaterialScrapList(materialScrap);
        return getDataTable(list);
    }
    
    /**
     * 获取物料报废详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:scrap:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
          AjaxResult ajax =  AjaxResult.success(materialScrapService.selectMaterialScrapById(id));
          ajax.put("goods", busGoodsService.selectBusGoodsList(new BusGoods()));
          return ajax;
    }
    
    /**
     * 新增物料报废
     */
    @PreAuthorize("@ss.hasPermi('system:scrap:add')")
    @Log(title = "物料报废", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MaterialScrap materialScrap)
    {
        return toAjax(materialScrapService.insertMaterialScrap(materialScrap));
    }
    
    /**
     * 修改物料报废
     */
    @PreAuthorize("@ss.hasPermi('system:scrap:edit')")
    @Log(title = "物料报废", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MaterialScrap materialScrap)
    {
        return toAjax(materialScrapService.updateMaterialScrap(materialScrap));
    }
    
    /**
     * 删除物料报废
     */
    @PreAuthorize("@ss.hasPermi('system:scrap:remove')")
    @Log(title = "物料报废", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(materialScrapService.deleteMaterialScrapByIds(ids));
    }
}
