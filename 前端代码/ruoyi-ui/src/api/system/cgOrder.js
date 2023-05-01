import request from '@/utils/request'

// 查询采购订单管理列表
export function listCgOrder(query) {
  return request({
    url: '/system/cgOrder/list',
    method: 'get',
    params: query
  })
}

// 查询采购订单管理详细
export function getCgOrder(id) {
  return request({
    url: '/system/cgOrder/' + id,
    method: 'get'
  })
}

// 新增采购订单管理
export function addCgOrder(data) {
  return request({
    url: '/system/cgOrder',
    method: 'post',
    data: data
  })
}

// 修改采购订单管理
export function updateCgOrder(data) {
  return request({
    url: '/system/cgOrder',
    method: 'put',
    data: data
  })
}

// 删除采购订单管理
export function delCgOrder(id) {
  return request({
    url: '/system/cgOrder/' + id,
    method: 'delete'
  })
}

// 导出采购订单管理
export function exportCgOrder(query) {
  return request({
    url: '/system/cgOrder/export',
    method: 'get',
    params: query
  })
}