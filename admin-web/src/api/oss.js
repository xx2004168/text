import request from '@/utils/request'
export function policy() {
  return request({
    // url:'/aliyun/oss/policy',
    url:'/minio/upload',
    method:'post',
  })
}
