import request from '@/utils/request'
import { praseStrEmpty } from "@/utils/ruoyi";

// 查询商品列表
export function listGoods(query) {
  return request({
    url: '/system/goods/list',
    method: 'get',
    params: query
  })
}

// 查询商品详细
export function getGoods(id) {
	 
  return request({
    url: '/system/goods/' + praseStrEmpty(id),
    method: 'get'
  })
}

// 查询商品详细
export function newGoods() {
	 
  return request({
    url: '/system/goods/',
    method: 'get'
  })
}

// 新增商品
export function addGoods(data) {
  return request({
    url: '/system/goods',
    method: 'post',
    data: data
  })
}

// 修改商品
export function updateGoods(data) {
  return request({
    url: '/system/goods',
    method: 'put',
    data: data
  })
}

// 删除商品
export function delGoods(id) {
  return request({
    url: '/system/goods/' + id,
    method: 'delete'
  })
}

// 导出商品
export function exportGoods(query) {
  return request({
    url: '/system/goods/export',
    method: 'get',
    params: query
  })
}