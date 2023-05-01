import request from '@/utils/request'

// 查询单据查询列表
export function listShippingdoc(query) {
  return request({
    url: '/system/shippingdoc/list',
    method: 'get',
    params: query
  })
}

// 查询单据查询详细
export function getShippingdoc(id) {
  return request({
    url: '/system/shippingdoc/' + id,
    method: 'get'
  })
}

// 新增单据查询
export function addShippingdoc(data) {
  return request({
    url: '/system/shippingdoc',
    method: 'post',
    data: data
  })
}

// 修改单据查询
export function updateShippingdoc(data) {
  return request({
    url: '/system/shippingdoc',
    method: 'put',
    data: data
  })
}

// 删除单据查询
export function delShippingdoc(id) {
  return request({
    url: '/system/shippingdoc/' + id,
    method: 'delete'
  })
}

// 导出单据查询
export function exportShippingdoc(query) {
  return request({
    url: '/system/shippingdoc/export',
    method: 'get',
    params: query
  })
}