import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-product/productAttribute/category/page',
    method:'get',
    params:params
  })
}

export function createProductAttrCate(data) {
  return request({
    url:'/shop-product/productAttribute/category/create',
    method:'post',
    data:data
  })
}

export function deleteProductAttrCate(id) {
  return request({
    url:'/shop-product/productAttribute/category/delete/'+id,
    method:'get'
  })
}

export function updateProductAttrCate(id,data) {
  return request({
    url:'/shop-product/productAttribute/category/update/'+id,
    method:'post',
    data:data
  })
}

//这个后边补上
export function fetchListWithAttr() {
  return request({
    url:'/shop-product/productAttribute/category/list/withAttr',
    method:'get'
  })
}
