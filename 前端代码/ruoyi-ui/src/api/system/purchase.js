import request from '@/utils/request'

// 查询采购申请列表
export function listPurchase(query) {
  return request({
    url: '/system/purchase/list',
    method: 'get',
    params: query
  })
}

// 查询采购申请详细
export function getPurchase(id) {
  return request({
    url: '/system/purchase/' + id,
    method: 'get'
  })
}

// 新增采购申请
export function addPurchase(data) {
  return request({
    url: '/system/purchase',
    method: 'post',
    data: data
  })
}

// 修改采购申请
export function updatePurchase(data) {
  return request({
    url: '/system/purchase',
    method: 'put',
    data: data
  })
}

// 删除采购申请
export function delPurchase(id) {
  return request({
    url: '/system/purchase/' + id,
    method: 'delete'
  })
}

// 导出采购申请
export function exportPurchase(query) {
  return request({
    url: '/system/purchase/export',
    method: 'get',
    params: query
  })
}