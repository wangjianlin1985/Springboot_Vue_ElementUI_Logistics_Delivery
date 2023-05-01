import request from '@/utils/request'

// 查询客户订单查询列表
export function listCustomorder(query) {
  return request({
    url: '/system/customorder/list',
    method: 'get',
    params: query
  })
}

// 查询客户订单查询详细
export function getCustomorder(id) {
  return request({
    url: '/system/customorder/' + id,
    method: 'get'
  })
}

// 新增客户订单查询
export function addCustomorder(data) {
  return request({
    url: '/system/customorder',
    method: 'post',
    data: data
  })
}

// 修改客户订单查询
export function updateCustomorder(data) {
  return request({
    url: '/system/customorder',
    method: 'put',
    data: data
  })
}

// 删除客户订单查询
export function delCustomorder(id) {
  return request({
    url: '/system/customorder/' + id,
    method: 'delete'
  })
}

// 导出客户订单查询
export function exportCustomorder(query) {
  return request({
    url: '/system/customorder/export',
    method: 'get',
    params: query
  })
}