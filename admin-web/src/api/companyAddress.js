import request from '@/utils/request'
export function fetchList() {
  return request({
    url:'/shop-order/companyAddress/list',
    method:'get'
  })
}
