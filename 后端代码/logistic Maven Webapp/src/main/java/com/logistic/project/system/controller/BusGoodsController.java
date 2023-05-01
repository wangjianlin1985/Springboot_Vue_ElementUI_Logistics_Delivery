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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.aspectj.lang.annotation.Log;
import com.logistic.framework.aspectj.lang.enums.BusinessType;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.framework.web.page.TableDataInfo;
import com.logistic.project.system.domain.BusGoods;
import com.logistic.project.system.domain.BusProvider;
import com.logistic.project.system.service.IBusGoodsService;
import com.logistic.project.system.service.IBusProviderService;

/**
 * 
 * <商品Controller>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年4月23日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping("/system/goods")
public class BusGoodsController extends BaseController
{
    @Autowired
    private IBusGoodsService busGoodsService;
    
    @Autowired
    private IBusProviderService busProviderService;

    /**
     * 查询商品列表
     */
    @PreAuthorize("@ss.hasPermi('system:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusGoods busGoods)
    {
        startPage();
        List<BusGoods> list = busGoodsService.selectBusGoodsList(busGoods);
        return getDataTable(list);
    }

  

    /**
     * 获取商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:query')")
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        AjaxResult ajax = AjaxResult.success(busGoodsService.selectBusGoodsById(id));
            
        ajax.put("providers", busProviderService.selectBusProviderList(new BusProvider()));
        return ajax;
    }
    
    @PreAuthorize("@ss.hasPermi('system:goods:query')")
    @GetMapping()
    public AjaxResult getInfo()
    {
        AjaxResult ajax = AjaxResult.success();
            
        ajax.put("providers", busProviderService.selectBusProviderList(new BusProvider()));
        return ajax;
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('system:goods:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusGoods busGoods)
    {
        return toAjax(busGoodsService.insertBusGoods(busGoods));
    }

    /**
     * 修改商品
     */
    @PreAuthorize("@ss.hasPermi('system:goods:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusGoods busGoods)
    {
        return toAjax(busGoodsService.updateBusGoods(busGoods));
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('system:goods:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busGoodsService.deleteBusGoodsByIds(ids));
    }
}
