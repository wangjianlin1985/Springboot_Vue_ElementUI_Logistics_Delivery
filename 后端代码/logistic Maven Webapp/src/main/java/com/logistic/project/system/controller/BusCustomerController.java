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
import com.logistic.project.system.domain.BusCustomer;
import com.logistic.project.system.service.IBusCustomerService;

/**
 * 客户Controller
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年5月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping("/system/customer")
public class BusCustomerController extends BaseController
{
    @Autowired
    private IBusCustomerService busCustomerService;

    /**
     * 查询客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusCustomer busCustomer)
    {
        startPage();
        List<BusCustomer> list = busCustomerService.selectBusCustomerList(busCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:customer:export')")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BusCustomer busCustomer)
    {
        List<BusCustomer> list = busCustomerService.selectBusCustomerList(busCustomer);
        ExcelUtil<BusCustomer> util = new ExcelUtil<BusCustomer>(BusCustomer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 获取客户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:customer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(busCustomerService.selectBusCustomerById(id));
    }

    /**
     * 新增客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:add')")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusCustomer busCustomer)
    {
        return toAjax(busCustomerService.insertBusCustomer(busCustomer));
    }

    /**
     * 修改客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:edit')")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusCustomer busCustomer)
    {
        return toAjax(busCustomerService.updateBusCustomer(busCustomer));
    }

    /**
     * 删除客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:remove')")
    @Log(title = "客户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(busCustomerService.deleteBusCustomerByIds(ids));
    }
}
