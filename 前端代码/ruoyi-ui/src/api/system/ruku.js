import request from '@/utils/request'

// 查询入库接单列表
export function listRuku(query) {
  return request({
    url: '/system/ruku/list',
    method: 'get',
    params: query
  })
}

// 查询入库接单详细
export function getRuku(id) {
  return request({
    url: '/system/ruku/' + id,
    method: 'get'
  })
}

// 新增入库接单
export function addRuku(data) {
  return request({
    url: '/system/ruku',
    method: 'post',
    data: data
  })
}

// 修改入库接单
export function updateRuku(data) {
  return request({
    url: '/system/ruku',
    method: 'put',
    data: data
  })
}

// 删除入库接单
export function delRuku(id) {
  return request({
    url: '/system/ruku/' + id,
    method: 'delete'
  })
}

// 导出入库接单
export function exportRuku(query) {
  return request({
    url: '/system/ruku/export',
    method: 'get',
    params: query
  })
}