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
import com.logistic.project.system.domain.BusGoods;
import com.logistic.project.system.domain.CaigouOrderInfo;
import com.logistic.project.system.service.IBusCaigouOrderService;
import com.logistic.project.system.service.IBusGoodsService;
import com.logistic.project.system.service.ICaigouOrderInfoService;
import com.logistic.framework.web.controller.BaseController;
import com.logistic.framework.web.domain.AjaxResult;
import com.logistic.common.utils.poi.ExcelUtil;
import com.logistic.framework.web.page.TableDataInfo;

/**
 * 采购物料明细Controller
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping("/system/cgOrderInfo")
public class CaigouOrderInfoController extends BaseController
{
    @Autowired
    private ICaigouOrderInfoService caigouOrderInfoService;
    
    @Autowired
    private IBusGoodsService busGoodsService;
    
    @Autowired
    private  IBusCaigouOrderService  busCaigouOrderService;

    /**
     * 查询采购物料明细列表
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrderInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CaigouOrderInfo caigouOrderInfo)
    {
        startPage();
        List<CaigouOrderInfo> list = caigouOrderInfoService.selectCaigouOrderInfoList(caigouOrderInfo);
        return getDataTable(list);
    }

    

    /**
     * 获取采购物料明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrderInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        AjaxResult ajax =  AjaxResult.success(caigouOrderInfoService.selectCaigouOrderInfoById(id));
        //获得所有的商品列表
        ajax.put("goods",busGoodsService.selectBusGoodsList(new BusGoods()));
        ajax.put("caiGouOrders",busCaigouOrderService.selectBusCaigouOrderList(new BusCaigouOrder()));
        return ajax;
    }

    /**
     * 新增采购物料明细
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrderInfo:add')")
    @Log(title = "采购物料明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CaigouOrderInfo caigouOrderInfo)
    {
        return toAjax(caigouOrderInfoService.insertCaigouOrderInfo(caigouOrderInfo));
    }

    /**
     * 修改采购物料明细
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrderInfo:edit')")
    @Log(title = "采购物料明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CaigouOrderInfo caigouOrderInfo)
    {
        return toAjax(caigouOrderInfoService.updateCaigouOrderInfo(caigouOrderInfo));
    }

    /**
     * 删除采购物料明细
     */
    @PreAuthorize("@ss.hasPermi('system:cgOrderInfo:remove')")
    @Log(title = "采购物料明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(caigouOrderInfoService.deleteCaigouOrderInfoByIds(ids));
    }
}
