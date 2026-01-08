import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-user/memberLevel/list',
    method:'get',
    params:params
  })
}
