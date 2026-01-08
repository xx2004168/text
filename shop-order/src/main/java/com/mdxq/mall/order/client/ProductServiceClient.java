package com.mdxq.mall.order.client;


import com.mdxq.mall.response.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "shop-product")
public interface ProductServiceClient {
    @PostMapping("/api/v1/product/restocking")
    R restocking(@RequestParam Long pid, @RequestParam Integer num);
}
