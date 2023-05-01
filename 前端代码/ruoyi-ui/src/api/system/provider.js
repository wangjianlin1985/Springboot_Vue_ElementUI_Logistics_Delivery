import request from '@/utils/request'

// 查询供应商列表
export function listProvider(query) {
  return request({
    url: '/system/provider/list',
    method: 'get',
    params: query
  })
}

// 查询供应商详细
export function getProvider(id) {
  return request({
    url: '/system/provider/' + id,
    method: 'get'
  })
}

// 新增供应商
export function addProvider(data) {
  return request({
    url: '/system/provider',
    method: 'post',
    data: data
  })
}

// 修改供应商
export function updateProvider(data) {
  return request({
    url: '/system/provider',
    method: 'put',
    data: data
  })
}

// 删除供应商
export function delProvider(id) {
  return request({
    url: '/system/provider/' + id,
    method: 'delete'
  })
}

// 导出供应商
export function exportProvider(query) {
  return request({
    url: '/system/provider/export',
    method: 'get',
    params: query
  })
}