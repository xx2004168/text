import request from '@/utils/request'
import formatDate from '@/utils/date'

export function fetchList(params) {
  return request({
    url: '/shop-sale/flashSession/list',
    method: 'get',
    params: params
  })
}

export function fetchSelectList(params) {
  return request({
    url: '/shop-sale/flashSession/selectList',
    // url: '/shop-sale/flashSession/list',
    method: 'get',
    params: params
  })
}

export function updateStatus(id, params) {
  return request({
    url: '/shop-sale/flashSession/update/status/' + id,
    method: 'post',
    params: params
  })
}

export function deleteSession(id) {
  return request({
    url: '/shop-sale/flashSession/delete/' + id,
    method: 'delete'
  })
}

export function createSession(data) {
  return request({
    url: '/shop-sale/flashSession/save',
    method: 'post',
    data: data
  })
}

export function updateSession(id, data) {
  return request({
    url: '/shop-sale/flashSession/update/' + id,
    method: 'put',
    data: data
  })
}
