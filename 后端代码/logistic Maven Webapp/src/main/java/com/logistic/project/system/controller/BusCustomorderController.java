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
import com.logistic.project.system.domain.BusCustomorder;
import com.logistic.project.system.service.IBusCustomorderService;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.web.page.TableDataInfo;

/**
 * 客户订单查询Controller
 * 
 * @author mg
 * @date 2020-05-17
 */
@RestController
@RequestMapping("/system/customorder")
public class BusCustomorderController extends BaseController
{
    @Autowired
    private IBusCustomorderService busCustomorderService;

    /**
     * 查询客户订单查询列表
     */
    @PreAuthorize("@ss.hasPermi('system:customorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusCustomorder busCustomorder)
    {
        startPage();
        List<BusCustomorder> list = busCustomorderService.selectBusCustomorderList(busCustomorder);
        return getDataTable(list);
    }

    /**
     * 导出客户订单查询列表
     */
    @PreAuthorize("@ss.hasPermi('system:customorder:export')")
    @Log(title = "客户订单查询", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusCustomorder busCustomorder)
    {
        List<BusCustomorder> list = busCustomorderService.selectBusCustomorderList(busCustomorder);
        ExcelUtil<BusCustomorder> util = new ExcelUtil<BusCustomorder>(BusCustomorder.class);
        return util.exportExcel(list, "customorder");
    }

    /**
     * 获取客户订单查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:customorder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busCustomorderService.selectBusCustomorderById(id));
    }

    /**
     * 新增客户订单查询
     */
    @PreAuthorize("@ss.hasPermi('system:customorder:add')")
    @Log(title = "客户订单查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusCustomorder busCustomorder)
    {
        return toAjax(busCustomorderService.insertBusCustomorder(busCustomorder));
    }

    /**
     * 修改客户订单查询
     */
    @PreAuthorize("@ss.hasPermi('system:customorder:edit')")
    @Log(title = "客户订单查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusCustomorder busCustomorder)
    {
        return toAjax(busCustomorderService.updateBusCustomorder(busCustomorder));
    }

    /**
     * 删除客户订单查询
     */
    @PreAuthorize("@ss.hasPermi('system:customorder:remove')")
    @Log(title = "客户订单查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busCustomorderService.deleteBusCustomorderByIds(ids));
    }
}
