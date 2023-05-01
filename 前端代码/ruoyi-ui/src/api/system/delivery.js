import request from '@/utils/request'

// 查询配送运输列表
export function listDelivery(query) {
  return request({
    url: '/system/delivery/list',
    method: 'get',
    params: query
  })
}

// 查询配送运输详细
export function getDelivery(id) {
  return request({
    url: '/system/delivery/' + id,
    method: 'get'
  })
}

// 新增配送运输
export function addDelivery(data) {
  return request({
    url: '/system/delivery',
    method: 'post',
    data: data
  })
}

// 修改配送运输
export function updateDelivery(data) {
  return request({
    url: '/system/delivery',
    method: 'put',
    data: data
  })
}

// 删除配送运输
export function delDelivery(id) {
  return request({
    url: '/system/delivery/' + id,
    method: 'delete'
  })
}

// 导出配送运输
export function exportDelivery(query) {
  return request({
    url: '/system/delivery/export',
    method: 'get',
    params: query
  })
}