import request from '@/utils/request'

// 查询出库管理列表
export function listOutport(query) {
  return request({
    url: '/system/outport/list',
    method: 'get',
    params: query
  })
}

// 查询出库管理详细
export function getOutport(id) {
  return request({
    url: '/system/outport/' + id,
    method: 'get'
  })
}

// 新增出库管理
export function addOutport(data) {
  return request({
    url: '/system/outport',
    method: 'post',
    data: data
  })
}

// 修改出库管理
export function updateOutport(data) {
  return request({
    url: '/system/outport',
    method: 'put',
    data: data
  })
}

// 删除出库管理
export function delOutport(id) {
  return request({
    url: '/system/outport/' + id,
    method: 'delete'
  })
}

// 导出出库管理
export function exportOutport(query) {
  return request({
    url: '/system/outport/export',
    method: 'get',
    params: query
  })
}