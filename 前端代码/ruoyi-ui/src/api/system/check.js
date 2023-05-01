import request from '@/utils/request'

// 查询仓库检查列表
export function listCheck(query) {
  return request({
    url: '/system/check/list',
    method: 'get',
    params: query
  })
}

// 查询仓库检查详细
export function getCheck(id) {
  return request({
    url: '/system/check/' + id,
    method: 'get'
  })
}

// 新增仓库检查
export function addCheck(data) {
  return request({
    url: '/system/check',
    method: 'post',
    data: data
  })
}

// 修改仓库检查
export function updateCheck(data) {
  return request({
    url: '/system/check',
    method: 'put',
    data: data
  })
}

// 删除仓库检查
export function delCheck(id) {
  return request({
    url: '/system/check/' + id,
    method: 'delete'
  })
}

// 导出仓库检查
export function exportCheck(query) {
  return request({
    url: '/system/check/export',
    method: 'get',
    params: query
  })
}