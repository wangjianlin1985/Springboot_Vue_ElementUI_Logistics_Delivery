import request from '@/utils/request'

// 查询物料报废列表
export function listScrap(query) {
  return request({
    url: '/system/scrap/list',
    method: 'get',
    params: query
  })
}

// 查询物料报废详细
export function getScrap(id) {
  return request({
    url: '/system/scrap/' + id,
    method: 'get'
  })
}

// 新增物料报废
export function addScrap(data) {
  return request({
    url: '/system/scrap',
    method: 'post',
    data: data
  })
}

// 修改物料报废
export function updateScrap(data) {
  return request({
    url: '/system/scrap',
    method: 'put',
    data: data
  })
}

// 删除物料报废
export function delScrap(id) {
  return request({
    url: '/system/scrap/' + id,
    method: 'delete'
  })
}

// 导出物料报废
export function exportScrap(query) {
  return request({
    url: '/system/scrap/export',
    method: 'get',
    params: query
  })
}