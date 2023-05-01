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
import com.logistic.project.system.domain.BusCaigouOrder;
import com.logistic.project.system.domain.BusProvider;
import com.logistic.project.system.service.IBusCaigouOrderService;
import com.logistic.project.system.service.IBusProviderService;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.web.page.TableDataInfo;

/**
 * 采购订单管理Controller
 * 
 * @author mage
 * @date 2020-05-17
 */
@RestController
@RequestMapping("/system/cgOrder")
public class BusCaigouOrderController extends BaseController
{
    @Autowired
    private IBusCaigouOrderService busCaigouOrderService;
    
    @Autowired
    private IBusProviderService busProviderService;
    
    /**
     * 查询采购订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusCaigouOrder busCaigouOrder)
    {
        startPage();
        List<BusCaigouOrder> list = busCaigouOrderService.selectBusCaigouOrderList(busCaigouOrder);
        return getDataTable(list);
    }
    
    /**
     * 获取采购订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        AjaxResult ajax = AjaxResult.success(busCaigouOrderService.selectBusCaigouOrderById(id));
        ajax.put("providers", busProviderService.selectBusProviderList(new BusProvider()));
        return ajax;
    }
    
    /**
     * 新增采购订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrder:add')")
    @Log(title = "采购订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusCaigouOrder busCaigouOrder)
    {
        return toAjax(busCaigouOrderService.insertBusCaigouOrder(busCaigouOrder));
    }
    
    /**
     * 修改采购订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrder:edit')")
    @Log(title = "采购订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusCaigouOrder busCaigouOrder)
    {
        return toAjax(busCaigouOrderService.updateBusCaigouOrder(busCaigouOrder));
    }
    
    /**
     * 删除采购订单管理
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrder:remove')")
    @Log(title = "采购订单管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busCaigouOrderService.deleteBusCaigouOrderByIds(ids));
    }
}
