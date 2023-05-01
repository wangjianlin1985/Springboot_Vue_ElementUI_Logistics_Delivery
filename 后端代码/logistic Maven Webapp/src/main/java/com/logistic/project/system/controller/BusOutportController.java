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
import com.logistic.project.system.domain.BusGoods;
import com.logistic.project.system.domain.BusOutport;
import com.logistic.project.system.domain.BusProvider;
import com.logistic.project.system.service.IBusGoodsService;
import com.logistic.project.system.service.IBusOutportService;
import com.logistic.project.system.service.IBusProviderService;

/**
 * 出库管理Controller
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping("/system/outport")
public class BusOutportController extends BaseController
{
    @Autowired
    private IBusOutportService busOutportService;

    @Autowired
    private IBusProviderService busProviderService;
    
    @Autowired
    private IBusGoodsService busGoodsService;
    
    /**
     * 查询出库管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:outport:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusOutport busOutport)
    {
        startPage();
        List<BusOutport> list = busOutportService.selectBusOutportList(busOutport);
        return getDataTable(list);
    }

    /**
     * 导出出库管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:outport:export')")
    @Log(title = "出库管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusOutport busOutport)
    {
        List<BusOutport> list = busOutportService.selectBusOutportList(busOutport);
        ExcelUtil<BusOutport> util = new ExcelUtil<BusOutport>(BusOutport.class);
        return util.exportExcel(list, "outport");
    }

    /**
     * 获取出库管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:outport:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
    	AjaxResult ajax = AjaxResult.success(busOutportService.selectBusOutportById(id));
    
        ajax.put("providers", busProviderService.selectBusProviderList(new BusProvider()));
        ajax.put("goods",busGoodsService.selectBusGoodsList(new BusGoods()));
        
        return ajax;
    }

    /**
     * 新增出库管理
     */
    @PreAuthorize("@ss.hasPermi('system:outport:add')")
    @Log(title = "出库管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusOutport busOutport)
    {
        return toAjax(busOutportService.insertBusOutport(busOutport));
    }

    /**
     * 修改出库管理
     */
    @PreAuthorize("@ss.hasPermi('system:outport:edit')")
    @Log(title = "出库管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusOutport busOutport)
    {
        return toAjax(busOutportService.updateBusOutport(busOutport));
    }

    /**
     * 删除出库管理
     */
    @PreAuthorize("@ss.hasPermi('system:outport:remove')")
    @Log(title = "出库管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busOutportService.deleteBusOutportByIds(ids));
    }
}
