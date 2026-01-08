import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-order/returnReason/page',
    method:'get',
    params:params
  })
}

export function deleteReason(params) {
  return request({
    url:'/shop-order/returnReason/delete',
    method:'delete',
    params:params
  })
}

export function updateStatus(params) {
  return request({
    url:'/shop-order/returnReason/update/status',
    method:'post',
    params:params
  })
}

export function addReason(data) {
  return request({
    url:'/shop-order/returnReason/save',
    method:'post',
    data:data
  })
}

export function getReasonDetail(id) {
  return request({
    url:'/shop-order/returnReason/getInfo/'+id,
    method:'get'
  })
}

export function updateReason(id,data) {
  return request({
    url:'/shop-order/returnReason/update/'+id,
    method:'put',
    data:data
  })
}
