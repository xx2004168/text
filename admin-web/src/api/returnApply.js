import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-order/returnApply/page',
    method:'get',
    params:params
  })
}

export function deleteApply(params) {
  return request({
    url:'/shop-order/returnApply/delete',
    method:'delete',
    params:params
  })
}
export function updateApplyStatus(id,data) {
  return request({
    url:'/shop-order/returnApply/update/status/'+id,
    method:'post',
    data:data
  })
}

export function getApplyDetail(id) {
  return request({
    url:'/shop-order/returnApply/getInfo/'+id,
    method:'get'
  })
}
