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

import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.aspectj.lang.annotation.Log;
import com.logistic.framework.aspectj.lang.enums.BusinessType;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.framework.web.page.TableDataInfo;
import com.logistic.project.system.domain.BusProvider;
import com.logistic.project.system.service.IBusProviderService;

/**
 * 供应商Controller
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping("/system/provider")
public class BusProviderController extends BaseController
{
    @Autowired
    private IBusProviderService busProviderService;

    /**
     * 查询供应商列表
     */
    @PreAuthorize("@ss.hasPermi('system:provider:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusProvider busProvider)
    {
        startPage();
        List<BusProvider> list = busProviderService.selectBusProviderList(busProvider);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @PreAuthorize("@ss.hasPermi('system:provider:export')")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusProvider busProvider)
    {
        List<BusProvider> list = busProviderService.selectBusProviderList(busProvider);
        ExcelUtil<BusProvider> util = new ExcelUtil<BusProvider>(BusProvider.class);
        return util.exportExcel(list, "provider");
    }

    /**
     * 获取供应商详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:provider:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busProviderService.selectBusProviderById(id));
    }

    /**
     * 新增供应商
     */
    @PreAuthorize("@ss.hasPermi('system:provider:add')")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusProvider busProvider)
    {
        return toAjax(busProviderService.insertBusProvider(busProvider));
    }

    /**
     * 修改供应商
     */
    @PreAuthorize("@ss.hasPermi('system:provider:edit')")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusProvider busProvider)
    {
        return toAjax(busProviderService.updateBusProvider(busProvider));
    }

    /**
     * 删除供应商
     */
    @PreAuthorize("@ss.hasPermi('system:provider:remove')")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busProviderService.deleteBusProviderByIds(ids));
    }
}
