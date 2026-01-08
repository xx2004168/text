import request from '@/utils/request'

export function fetchList(params) {
  // 让后端能够接收到这个参数
  // params.pageNumber = params.pageNum
  // params.pageNum = undefined
  return request({
    url: '/shop-user/role/page',
    method: 'get',
    params: params
  })
}

export function createRole(data) {
  return request({
    url: '/shop-user/role/save',
    method: 'post',
    data: data
  })
}

export function updateRole(id, data) {
  return request({
    url: '/shop-user/role/update/' + id,
    method: 'put',
    data: data
  })
}

export function updateStatus(id, params) {
  return request({
    url: '/shop-user/role/updateStatus/' + id,
    method: 'post',
    params: params
  })
}

export function deleteRole(data) {
  return request({
    url:'/shop-user/role/delete',
    method:'delete',
    data:data
  })
}

export function fetchAllRoleList() {
  return request({
    url: '/shop-user/role/list',
    method: 'get',
  })
}

export function listMenuByRole(roleId) {
  return request({
    url: '/shop-user/role/listMenu/'+roleId,
    method: 'get'
  })
}

export function listResourceByRole(roleId) {
  return request({
    url: '/shop-user/role/listResource/'+roleId,
    method: 'get'
  })
}

export function allocMenu(data) {
  return request({
    url: '/shop-user/role/allocMenu',
    method: 'post',
    data:data
  })
}

export function allocResource(data) {
  return request({
    url: '/shop-user/role/allocResource',
    method: 'post',
    data:data
  })
}
