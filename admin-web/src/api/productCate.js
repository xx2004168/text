import request from '@/utils/request'
export function fetchList(parentId,params) {
  return request({
    // url:'/shop-product/productCategory/list/'+parentId,
    url:'/shop-product/productCategory/page/' + parentId,
    method:'get',
    params:params
  })
}
export function deleteProductCate(id) {
  return request({
    url:'/shop-product/productCategory/delete/'+id,
    method:'delete'
  })
}

export function createProductCate(data) {
  return request({
    url:'/shop-product/productCategory/save',
    method:'post',
    data:data
  })
}

export function updateProductCate(id,data) {
  return request({
    url:'/shop-product/productCategory/update/'+id,
    method:'post',
    data:data
  })
}

export function getProductCate(id) {
  return request({
    url:'/shop-product/productCategory/getInfo/'+id,
    method:'get',
  })
}

export function updateShowStatus(data) {
  return request({
    url:'/shop-product/productCategory/update/showStatus',
    method:'post',
    data:data
  })
}

export function updateNavStatus(data) {
  return request({
    url:'/shop-product/productCategory/update/navStatus',
    method:'post',
    data:data
  })
}
//添加商品时用到这个方法
export function fetchListWithChildren() {
  return request({
    url:'/shop-product/productCategory/list/withChildren',
    method:'get'
  })
}
