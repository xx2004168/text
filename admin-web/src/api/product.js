import request from '@/utils/request'
// 搞定
export function fetchList(params) {
  return request({
    url:'/shop-product/product/page',
    method:'get',
    params:params
  })
}
// 搞定
//最后做，订单模块做
export function fetchSimpleList(params) {
  return request({
    url:'/shop-product/product/simpleList',
    method:'get',
    params:params
  })
}

export function updateDeleteStatus(params) {
  return request({
    url:'/shop-product/product/update/deleteStatus',
    method:'delete',
    params:params
  })
}

export function updateNewStatus(params) {
  return request({
    url:'/shop-product/product/update/newStatus',
    method:'post',
    params:params
  })
}

export function updateRecommendStatus(params) {
  return request({
    url:'/shop-product/product/update/recommendStatus',
    method:'post',
    params:params
  })
}

export function updatePublishStatus(params) {
  return request({
    url:'/shop-product/product/update/publishStatus',
    method:'post',
    params:params
  })
}

export function createProduct(data) {
  return request({
    url:'/shop-product/product/save',
    method:'post',
    data:data
  })
}

export function updateProduct(id,data) {
  return request({
    url:'/shop-product/product/update',
    method:'post',
    data:data
  })
}

export function getProduct(id) {
  return request({
    url:'/shop-product/product/getInfo/'+id,
    method:'get',
  })
}

