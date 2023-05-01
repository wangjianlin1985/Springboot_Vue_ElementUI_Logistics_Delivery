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
import com.logistic.project.system.domain.BusInport;
import com.logistic.project.system.service.IBusGoodsService;
import com.logistic.project.system.service.IBusInportService;

/**
 * 采购管理
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping("/system/inport")
public class BusInportController extends BaseController
{
    @Autowired
    private IBusInportService busInportService;
    
    @Autowired
    private IBusGoodsService busGoodsService;

    /**
     * 查询采购管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:inport:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusInport busInport)
    {
        startPage();
        List<BusInport> list = busInportService.selectBusInportList(busInport);
        return getDataTable(list);
    }

    /**
     * 导出采购管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:inport:export')")
    @Log(title = "采购管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusInport busInport)
    {
        List<BusInport> list = busInportService.selectBusInportList(busInport);
        ExcelUtil<BusInport> util = new ExcelUtil<BusInport>(BusInport.class);
        return util.exportExcel(list, "inport");
    }

    /**
     * 获取采购管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:inport:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
         AjaxResult ajax = AjaxResult.success(busInportService.selectBusInportById(id));
         ajax.put("goods", busGoodsService.selectBusGoodsList(new BusGoods()));
         return ajax;
    }

    /**
     * 新增采购管理
     */
    @PreAuthorize("@ss.hasPermi('system:inport:add')")
    @Log(title = "采购管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusInport busInport)
    {
        return toAjax(busInportService.insertBusInport(busInport));
    }

    /**
     * 修改采购管理
     */
    @PreAuthorize("@ss.hasPermi('system:inport:edit')")
    @Log(title = "采购管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusInport busInport)
    {
        return toAjax(busInportService.updateBusInport(busInport));
    }

    /**
     * 删除采购管理
     */
    @PreAuthorize("@ss.hasPermi('system:inport:remove')")
    @Log(title = "采购管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busInportService.deleteBusInportByIds(ids));
    }
}
