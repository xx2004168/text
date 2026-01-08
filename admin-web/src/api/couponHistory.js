import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/couponHistory/page',
    method:'get',
    params:params
  })
}
