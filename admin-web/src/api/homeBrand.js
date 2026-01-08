import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/home/brand/page',
    method:'get',
    params:params
  })
}

export function updateRecommendStatus(data) {
  return request({
    url:'/shop-sale/home/brand/update/recommendStatus',
    method:'post',
    data:data
  })
}

export function deleteHomeBrand(data) {
  return request({
    url:'/shop-sale/home/brand/delete',
    method:'delete',
    data:data
  })
}

export function createHomeBrand(data) {
  return request({
    url:'/shop-sale/home/brand/save',
    method:'post',
    data:data
  })
}

export function updateHomeBrandSort(params) {
  return request({
    url:'/shop-sale/home/brand/update/sort/'+params.id,
    method:'post',
    params:params
  })
}
