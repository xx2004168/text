import request from '@/utils/request'

export function listAllCate() {
  return request({
    url: '/shop-user/resourceCategory/list',
    method: 'get'
  })
}

export function createResourceCategory(data) {
  return request({
    url: '/shop-user/resourceCategory/save',
    method: 'post',
    data: data
  })
}

export function updateResourceCategory(id, data) {
  return request({
    url: '/shop-user/resourceCategory/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteResourceCategory(id) {
  return request({
    url: '/shop-user/resourceCategory/delete/' + id,
    method: 'delete'
  })
}
