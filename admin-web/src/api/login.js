import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/shop-user/admin/login',//增加用户微服务ID和请求路径前缀 http://localhost:7000/shop-user/admin/login
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function getInfo() {
  return request({
    url: '/shop-user/admin/getInfo',
    method: 'get',
  })
}

export function logout() {
  return request({
    url: '/shop-user/admin/logout',
    method: 'post'
  })
}

export function fetchList(params) {
  return request({
    url: '/shop-user/admin/page',
    method: 'get',
    params: params
  })
}

export function createAdmin(data) {
  return request({
    url: '/shop-user/admin/save',
    method: 'post',
    data: data
  })
}

export function updateAdmin(id, data) {
  return request({
    url: '/shop-user/admin/update/' + id,
    method: 'put',
    data: data
  })
}

export function updateStatus(id, params) {
  return request({
    url: '/shop-user/admin/updateStatus/' + id,
    method: 'post',
    params: params
  })
}

export function deleteAdmin(id) {
  return request({
    url: '/shop-user/admin/delete/' + id,
    method: 'delete'
  })
}

export function getRoleByAdmin(id) {
  return request({
    url: '/shop-user/admin/role/' + id,
    method: 'get'
  })
}

export function allocRole(data) {
  return request({
    url: '/shop-user/admin/role/update',
    method: 'post',
    data: data
  })
}
