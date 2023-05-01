package com.logistic.project.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import com.logistic.project.system.domain.Shippingdoc;
import com.logistic.project.system.service.IBusGoodsService;
import com.logistic.project.system.service.IShippingdocService;

/**
 * 客户单据Controller
 * 
 * @author mg
 * @date 2020-05-17
 */
@RestController
@RequestMapping("/system/shippingdoc")
public class ShippingdocController extends BaseController
{
    @Autowired
    private IShippingdocService shippingdocService;
    
    @Autowired
    private IBusGoodsService busGoodsService;
    
    /**
     * 查询客户单据列表
     */
    @PreAuthorize("@ss.hasPermi('system:shippingdoc:list')")
    @GetMapping("/list")
    public TableDataInfo list(Shippingdoc shippingdoc)
    {
        startPage();
        List<Shippingdoc> list = shippingdocService.selectShippingdocList(shippingdoc);
        return getDataTable(list);
    }
    
    /**
     * 导出客户单据列表
     */
    @PreAuthorize("@ss.hasPermi('system:shippingdoc:export')")
    @Log(title = "客户单据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Shippingdoc shippingdoc)
    {
        List<Shippingdoc> list = shippingdocService.selectShippingdocList(shippingdoc);
        ExcelUtil<Shippingdoc> util = new ExcelUtil<Shippingdoc>(Shippingdoc.class);
        return util.exportExcel(list, "shippingdoc");
    }
    
    /**
     * 获取客户单据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:shippingdoc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        AjaxResult ajax = AjaxResult.success(shippingdocService.selectShippingdocById(id));
        
        ajax.put("goods", busGoodsService.selectBusGoodsList(new BusGoods()));
        
        return ajax;
    }
    
    /**
     * 新增客户单据
     */
    @PreAuthorize("@ss.hasPermi('system:shippingdoc:add')")
    @Log(title = "客户单据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Shippingdoc shippingdoc)
    {
        return toAjax(shippingdocService.insertShippingdoc(shippingdoc));
    }
    
    /**
     * 修改客户单据
     */
    @PreAuthorize("@ss.hasPermi('system:shippingdoc:edit')")
    @Log(title = "客户单据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Shippingdoc shippingdoc)
    {
        return toAjax(shippingdocService.updateShippingdoc(shippingdoc));
    }
    
    /**
     * 删除客户单据
     */
    @PreAuthorize("@ss.hasPermi('system:shippingdoc:remove')")
    @Log(title = "客户单据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(shippingdocService.deleteShippingdocByIds(ids));
    }
}
