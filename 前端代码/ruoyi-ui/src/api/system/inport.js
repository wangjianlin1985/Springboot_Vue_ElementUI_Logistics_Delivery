import request from '@/utils/request'

// 查询采购管理列表
export function listInport(query) {
  return request({
    url: '/system/inport/list',
    method: 'get',
    params: query
  })
}

// 查询采购管理详细
export function getInport(id) {
  return request({
    url: '/system/inport/' + id,
    method: 'get'
  })
}

// 新增采购管理
export function addInport(data) {
  return request({
    url: '/system/inport',
    method: 'post',
    data: data
  })
}

// 修改采购管理
export function updateInport(data) {
  return request({
    url: '/system/inport',
    method: 'put',
    data: data
  })
}

// 删除采购管理
export function delInport(id) {
  return request({
    url: '/system/inport/' + id,
    method: 'delete'
  })
}

// 导出采购管理
export function exportInport(query) {
  return request({
    url: '/system/inport/export',
    method: 'get',
    params: query
  })
}