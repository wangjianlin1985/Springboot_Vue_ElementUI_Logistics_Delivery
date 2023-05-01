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
import com.logistic.project.system.domain.BusCkCheck;
import com.logistic.project.system.service.IBusCkCheckService;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.web.page.TableDataInfo;

/**
 * 仓库检查Controller
 * 
 * @author nuoyi
 * @date 2020-05-17
 */
@RestController
@RequestMapping("/system/check")
public class BusCkCheckController extends BaseController
{
    @Autowired
    private IBusCkCheckService busCkCheckService;

    /**
     * 查询仓库检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:check:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusCkCheck busCkCheck)
    {
        startPage();
        List<BusCkCheck> list = busCkCheckService.selectBusCkCheckList(busCkCheck);
        return getDataTable(list);
    }

    /**
     * 导出仓库检查列表
     */
    @PreAuthorize("@ss.hasPermi('system:check:export')")
    @Log(title = "仓库检查", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusCkCheck busCkCheck)
    {
        List<BusCkCheck> list = busCkCheckService.selectBusCkCheckList(busCkCheck);
        ExcelUtil<BusCkCheck> util = new ExcelUtil<BusCkCheck>(BusCkCheck.class);
        return util.exportExcel(list, "check");
    }

    /**
     * 获取仓库检查详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:check:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busCkCheckService.selectBusCkCheckById(id));
    }

    /**
     * 新增仓库检查
     */
    @PreAuthorize("@ss.hasPermi('system:check:add')")
    @Log(title = "仓库检查", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusCkCheck busCkCheck)
    {
        return toAjax(busCkCheckService.insertBusCkCheck(busCkCheck));
    }

    /**
     * 修改仓库检查
     */
    @PreAuthorize("@ss.hasPermi('system:check:edit')")
    @Log(title = "仓库检查", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusCkCheck busCkCheck)
    {
        return toAjax(busCkCheckService.updateBusCkCheck(busCkCheck));
    }

    /**
     * 删除仓库检查
     */
    @PreAuthorize("@ss.hasPermi('system:check:remove')")
    @Log(title = "仓库检查", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busCkCheckService.deleteBusCkCheckByIds(ids));
    }
}
