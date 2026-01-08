import request from '@/utils/request'
export function getOrderSetting(id) {
  return request({
    url:'/shop-order/orderSetting/getInfo/'+id,
    method:'get',
  })
}

export function updateOrderSetting(id,data) {
  return request({
    url:'/shop-order/orderSetting/update/'+id,
    method:'put',
    data:data
  })
}
