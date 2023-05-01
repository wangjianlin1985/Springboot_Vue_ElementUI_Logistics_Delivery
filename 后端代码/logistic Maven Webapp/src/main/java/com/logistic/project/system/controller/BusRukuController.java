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
import com.logistic.project.system.domain.BusRuku;
import com.logistic.project.system.service.IBusRukuService;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.web.page.TableDataInfo;

/**
 * 入库接单Controller
 * 
 * @author nuoyi
 * @date 2020-05-17
 */
@RestController
@RequestMapping("/system/ruku")
public class BusRukuController extends BaseController
{
    @Autowired
    private IBusRukuService busRukuService;

    /**
     * 查询入库接单列表
     */
    @PreAuthorize("@ss.hasPermi('system:ruku:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusRuku busRuku)
    {
        startPage();
        List<BusRuku> list = busRukuService.selectBusRukuList(busRuku);
        return getDataTable(list);
    }

    /**
     * 导出入库接单列表
     */
    @PreAuthorize("@ss.hasPermi('system:ruku:export')")
    @Log(title = "入库接单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusRuku busRuku)
    {
        List<BusRuku> list = busRukuService.selectBusRukuList(busRuku);
        ExcelUtil<BusRuku> util = new ExcelUtil<BusRuku>(BusRuku.class);
        return util.exportExcel(list, "ruku");
    }

    /**
     * 获取入库接单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ruku:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busRukuService.selectBusRukuById(id));
    }

    /**
     * 新增入库接单
     */
    @PreAuthorize("@ss.hasPermi('system:ruku:add')")
    @Log(title = "入库接单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusRuku busRuku)
    {
        return toAjax(busRukuService.insertBusRuku(busRuku));
    }

    /**
     * 修改入库接单
     */
    @PreAuthorize("@ss.hasPermi('system:ruku:edit')")
    @Log(title = "入库接单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusRuku busRuku)
    {
        return toAjax(busRukuService.updateBusRuku(busRuku));
    }

    /**
     * 删除入库接单
     */
    @PreAuthorize("@ss.hasPermi('system:ruku:remove')")
    @Log(title = "入库接单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busRukuService.deleteBusRukuByIds(ids));
    }
}
