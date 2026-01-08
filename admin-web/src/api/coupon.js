import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/coupon/page',
    method:'get',
    params:params
  })
}

export function createCoupon(data) {
  return request({
    url:'/shop-sale/coupon/save',
    method:'post',
    data:data
  })
}

export function getCoupon(id) {
  return request({
    url:'/shop-sale/coupon/getInfo/'+id,
    method:'get',
  })
}

export function updateCoupon(id,data) {
  return request({
    url:'/shop-sale/coupon/update/'+id,
    method:'put',
    data:data
  })
}

export function deleteCoupon(id) {
  return request({
    url:'/shop-sale/coupon/delete/'+id,
    method:'delete',
  })
}
