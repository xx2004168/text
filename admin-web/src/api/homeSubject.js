import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/home/recommendSubject/page',
    method:'get',
    params:params
  })
}

export function updateRecommendStatus(data) {
  return request({
    url:'/shop-sale/home/recommendSubject/update/recommendStatus',
    method:'post',
    data:data
  })
}

export function deleteHomeSubject(data) {
  return request({
    url:'/shop-sale/home/recommendSubject/delete',
    method:'delete',
    data:data
  })
}

export function createHomeSubject(data) {
  return request({
    url:'/shop-sale/home/recommendSubject/save',
    method:'post',
    data:data
  })
}

export function updateHomeSubjectSort(params) {
  return request({
    url:'/shop-sale/home/recommendSubject/update/sort/'+params.id,
    method:'post',
    params:params
  })
}
