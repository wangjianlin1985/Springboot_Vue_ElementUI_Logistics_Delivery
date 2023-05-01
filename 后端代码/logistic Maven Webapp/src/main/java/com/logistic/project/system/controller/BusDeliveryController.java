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
import com.logistic.project.system.domain.BusDelivery;
import com.logistic.project.system.domain.BusGoods;
import com.logistic.project.system.service.IBusDeliveryService;
import com.logistic.project.system.service.IBusGoodsService;

/**
 * 配送运输Controller
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月4日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping("/system/delivery")
public class BusDeliveryController extends BaseController
{
    @Autowired
    private IBusDeliveryService busDeliveryService;

    
    @Autowired
    private IBusGoodsService busGoodsService;
    
    /**
     * 查询配送运输列表
     */
    @PreAuthorize("@ss.hasPermi('system:delivery:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusDelivery busDelivery)
    {
        startPage();
        List<BusDelivery> list = busDeliveryService.selectBusDeliveryList(busDelivery);
        return getDataTable(list);
    }

    /**
     * 导出配送运输列表
     */
    @PreAuthorize("@ss.hasPermi('system:delivery:export')")
    @Log(title = "配送运输", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusDelivery busDelivery)
    {
        List<BusDelivery> list = busDeliveryService.selectBusDeliveryList(busDelivery);
        ExcelUtil<BusDelivery> util = new ExcelUtil<BusDelivery>(BusDelivery.class);
        return util.exportExcel(list, "delivery");
    }

    /**
     * 获取配送运输详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:delivery:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
    	AjaxResult ajax =  AjaxResult.success(busDeliveryService.selectBusDeliveryById(id));
        ajax.put("goods",busGoodsService.selectBusGoodsList(new BusGoods()));
        return ajax;
    }

    /**
     * 新增配送运输
     */
    @PreAuthorize("@ss.hasPermi('system:delivery:add')")
    @Log(title = "配送运输", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusDelivery busDelivery)
    {
        return toAjax(busDeliveryService.insertBusDelivery(busDelivery));
    }

    /**
     * 修改配送运输
     */
    @PreAuthorize("@ss.hasPermi('system:delivery:edit')")
    @Log(title = "配送运输", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusDelivery busDelivery)
    {
        return toAjax(busDeliveryService.updateBusDelivery(busDelivery));
    }

    /**
     * 删除配送运输
     */
    @PreAuthorize("@ss.hasPermi('system:delivery:remove')")
    @Log(title = "配送运输", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busDeliveryService.deleteBusDeliveryByIds(ids));
    }
}
