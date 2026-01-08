import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/home/advertise/page',
    method:'get',
    params:params
  })
}
export function updateStatus(id,params) {
  return request({
    url:'/shop-sale/home/advertise/update/status/'+id,
    method:'post',
    params:params
  })
}
export function deleteHomeAdvertise(data) {
  return request({
    url:'/shop-sale/home/advertise/delete',
    method:'delete',
    data:data
  })
}
export function createHomeAdvertise(data) {
  return request({
    url:'/shop-sale/home/advertise/save',
    method:'post',
    data:data
  })
}
export function getHomeAdvertise(id) {
  return request({
    url:'/shop-sale/home/advertise/getInfo/'+id,
    method:'get',
  })
}

export function updateHomeAdvertise(id,data) {
  return request({
    url:'/shop-sale/home/advertise/update/'+id,
    method:'post',
    data:data
  })
}
