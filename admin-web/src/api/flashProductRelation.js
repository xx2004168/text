import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/flashProductRelation/page',
    method:'get',
    params:params
  })
}
export function createFlashProductRelation(data) {
  return request({
    url:'/shop-sale/flashProductRelation/save',
    method:'post',
    data:data
  })
}
export function deleteFlashProductRelation(id) {
  return request({
    url:'/shop-sale/flashProductRelation/delete/'+id,
    method:'delete'
  })
}
export function updateFlashProductRelation(id,data) {
  return request({
    url:'/shop-sale/flashProductRelation/update/'+id,
    method:'put',
    data:data
  })
}
