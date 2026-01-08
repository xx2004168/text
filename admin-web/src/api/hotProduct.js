import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/home/recommendProduct/page',
    method:'get',
    params:params
  })
}

export function updateRecommendStatus(data) {
  return request({
    url:'/shop-sale/home/recommendProduct/update/recommendStatus',
    method:'post',
    data:data
  })
}

export function deleteHotProduct(data) {
  return request({
    url:'/shop-sale/home/recommendProduct/delete',
    method:'delete',
    data:data
  })
}

export function createHotProduct(data) {
  return request({
    url:'/shop-sale/home/recommendProduct/save',
    method:'post',
    data:data
  })
}

export function updateHotProductSort(params) {
  return request({
    url:'/shop-sale/home/recommendProduct/update/sort/'+params.id,
    method:'post',
    params:params
  })
}
