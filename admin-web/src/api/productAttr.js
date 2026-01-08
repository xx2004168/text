import request from '@/utils/request'
export function fetchList(cid,params) {
  return request({
    url:'/shop-product/productAttribute/page/'+cid,
    method:'get',
    params:params
  })
}

export function deleteProductAttr(data) {
  return request({
    url:'/shop-product/productAttribute/delete',
    method:'post',
    data:data
  })
}

export function createProductAttr(data) {
  return request({
    url:'/shop-product/productAttribute/save',
    method:'post',
    data:data
  })
}

export function updateProductAttr(id,data) {
  return request({
    url:'/shop-product/productAttribute/update/'+id,
    method:'post',
    data:data
  })
}
export function getProductAttr(id) {
  return request({
    url:'/shop-product/productAttribute/getInfo/'+id,
    method:'get'
  })
}
//这个后边补上
export function getProductAttrInfo(productCategoryId) {
  return request({
    url:'/shop-product/productAttribute/attrInfo/'+productCategoryId,
    method:'get'
  })
}
