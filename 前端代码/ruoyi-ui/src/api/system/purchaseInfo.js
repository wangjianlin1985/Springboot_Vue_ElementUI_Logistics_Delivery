import request from '@/utils/request'

// 查询申请物料明细列表
export function listPurchaseInfo(query) {
  return request({
    url: '/system/purchaseInfo/list',
    method: 'get',
    params: query
  })
}

// 查询申请物料明细详细
export function getPurchaseInfo(id) {
  return request({
    url: '/system/purchaseInfo/' + id,
    method: 'get'
  })
}

// 新增申请物料明细
export function addPurchaseInfo(data) {
  return request({
    url: '/system/purchaseInfo',
    method: 'post',
    data: data
  })
}

// 修改申请物料明细
export function updatePurchaseInfo(data) {
  return request({
    url: '/system/purchaseInfo',
    method: 'put',
    data: data
  })
}

// 删除申请物料明细
export function delPurchaseInfo(id) {
  return request({
    url: '/system/purchaseInfo/' + id,
    method: 'delete'
  })
}

// 导出申请物料明细
export function exportPurchaseInfo(query) {
  return request({
    url: '/system/purchaseInfo/export',
    method: 'get',
    params: query
  })
}