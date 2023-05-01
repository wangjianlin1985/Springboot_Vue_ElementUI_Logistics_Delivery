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
import com.logistic.project.system.domain.BusPurchase;
import com.logistic.project.system.service.IBusPurchaseService;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.web.page.TableDataInfo;

/**
 * 采购申请Controller
 * 
 * @author mg
 * @date 2020-05-17
 */
@RestController
@RequestMapping("/system/purchase")
public class BusPurchaseController extends BaseController
{
    @Autowired
    private IBusPurchaseService busPurchaseService;

    /**
     * 查询采购申请列表
     */
    @PreAuthorize("@ss.hasPermi('system:purchase:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusPurchase busPurchase)
    {
        startPage();
        List<BusPurchase> list = busPurchaseService.selectBusPurchaseList(busPurchase);
        return getDataTable(list);
    }

    /**
     * 导出采购申请列表
     */
    @PreAuthorize("@ss.hasPermi('system:purchase:export')")
    @Log(title = "采购申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusPurchase busPurchase)
    {
        List<BusPurchase> list = busPurchaseService.selectBusPurchaseList(busPurchase);
        ExcelUtil<BusPurchase> util = new ExcelUtil<BusPurchase>(BusPurchase.class);
        return util.exportExcel(list, "purchase");
    }

    /**
     * 获取采购申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:purchase:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busPurchaseService.selectBusPurchaseById(id));
    }

    /**
     * 新增采购申请
     */
    @PreAuthorize("@ss.hasPermi('system:purchase:add')")
    @Log(title = "采购申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusPurchase busPurchase)
    {
        return toAjax(busPurchaseService.insertBusPurchase(busPurchase));
    }

    /**
     * 修改采购申请
     */
    @PreAuthorize("@ss.hasPermi('system:purchase:edit')")
    @Log(title = "采购申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusPurchase busPurchase)
    {
        return toAjax(busPurchaseService.updateBusPurchase(busPurchase));
    }

    /**
     * 删除采购申请
     */
    @PreAuthorize("@ss.hasPermi('system:purchase:remove')")
    @Log(title = "采购申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busPurchaseService.deleteBusPurchaseByIds(ids));
    }
}
