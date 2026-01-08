import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/shop-user/resource/page',
    method: 'get',
    params: params
  })
}

export function createResource(data) {
  return request({
    url: '/shop-user/resource/save',
    method: 'post',
    data: data
  })
}

export function updateResource(id, data) {
  return request({
    url: '/shop-user/resource/update/' + id,
    method: 'put',
    data: data
  })
}

export function deleteResource(id) {
  return request({
    url: '/shop-user/resource/delete/' + id,
    method: 'delete'
  })
}

export function fetchAllResourceList() {
  return request({
    url: '/shop-user/resource/listAll',
    method: 'get'
  })
}
