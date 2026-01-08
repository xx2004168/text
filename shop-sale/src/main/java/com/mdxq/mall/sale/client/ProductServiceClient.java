package com.mdxq.mall.sale.client;

import com.mdxq.mall.response.R;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 封装一个远程调用商品服务查询商品信息的接口
@FeignClient(value = "shop-product")
//@Service
public interface ProductServiceClient {
    @GetMapping("/api/v1/product/getBaseInfo/{id}")
    public R getBaseInfo(@PathVariable Long id);
}
