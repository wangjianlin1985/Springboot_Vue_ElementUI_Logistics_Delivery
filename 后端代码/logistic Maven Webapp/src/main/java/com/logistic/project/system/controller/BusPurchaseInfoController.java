package com.logistic.project.system.controller;

import java.util.Date;
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
import com.logistic.project.system.domain.BusGoods;
import com.logistic.project.system.domain.BusPurchase;
import com.logistic.project.system.domain.BusPurchaseInfo;
import com.logistic.project.system.service.IBusGoodsService;
import com.logistic.project.system.service.IBusPurchaseInfoService;
import com.logistic.project.system.service.IBusPurchaseService;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.web.page.TableDataInfo;

/**
 * 申请物料明细Controller
 * 
 * @author mg
 * @date 2020-05-18
 */
@RestController
@RequestMapping("/system/purchaseInfo")
public class BusPurchaseInfoController extends BaseController
{
    @Autowired
    private IBusPurchaseInfoService busPurchaseInfoService;
    
    
    @Autowired
    private IBusPurchaseService busPurchaseService;
    
    @Autowired
    private IBusGoodsService busGoodsService;

    /**
     * 查询申请物料明细列表
     */
    @PreAuthorize("@ss.hasPermi('system:purchaseInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusPurchaseInfo busPurchaseInfo)
    {
        startPage();
        List<BusPurchaseInfo> list = busPurchaseInfoService.selectBusPurchaseInfoList(busPurchaseInfo);
        return getDataTable(list);
    }

     

    /**
     * 获取申请物料明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:purchaseInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        AjaxResult ajax =  AjaxResult.success(busPurchaseInfoService.selectBusPurchaseInfoById(id));
        //获得所有的采购申请订单
        ajax.put("purchases", busPurchaseService.selectBusPurchaseList(new BusPurchase()));
        //获得所有的商品列表
        ajax.put("goods",busGoodsService.selectBusGoodsList(new BusGoods()));
        return ajax;
    }

    /**
     * 新增申请物料明细
     */
    @PreAuthorize("@ss.hasPermi('system:purchaseInfo:add')")
    @Log(title = "申请物料明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusPurchaseInfo busPurchaseInfo)
    {
        busPurchaseInfo.setPurchaseDate(new  Date());
        return toAjax(busPurchaseInfoService.insertBusPurchaseInfo(busPurchaseInfo));
        
    }

    /**
     * 修改申请物料明细
     */
    @PreAuthorize("@ss.hasPermi('system:purchaseInfo:edit')")
    @Log(title = "申请物料明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusPurchaseInfo busPurchaseInfo)
    {
        return toAjax(busPurchaseInfoService.updateBusPurchaseInfo(busPurchaseInfo));
    }

    /**
     * 删除申请物料明细
     */
    @PreAuthorize("@ss.hasPermi('system:purchaseInfo:remove')")
    @Log(title = "申请物料明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busPurchaseInfoService.deleteBusPurchaseInfoByIds(ids));
    }
}
