import request from '@/utils/request'

// 查询采购物料明细列表
export function listCgOrderInfo(query) {
  return request({
    url: '/system/cgOrderInfo/list',
    method: 'get',
    params: query
  })
}

// 查询采购物料明细详细
export function getCgOrderInfo(id) {
  return request({
    url: '/system/cgOrderInfo/' + id,
    method: 'get'
  })
}

// 新增采购物料明细
export function addCgOrderInfo(data) {
  return request({
    url: '/system/cgOrderInfo',
    method: 'post',
    data: data
  })
}

// 修改采购物料明细
export function updateCgOrderInfo(data) {
  return request({
    url: '/system/cgOrderInfo',
    method: 'put',
    data: data
  })
}

// 删除采购物料明细
export function delCgOrderInfo(id) {
  return request({
    url: '/system/cgOrderInfo/' + id,
    method: 'delete'
  })
}

// 导出采购物料明细
export function exportCgOrderInfo(query) {
  return request({
    url: '/system/cgOrderInfo/export',
    method: 'get',
    params: query
  })
}