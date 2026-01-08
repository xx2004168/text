package com.mdxq.mall.user.client;

import com.mdxq.mall.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("shop-order")
@RequestMapping("/api/v1/order")
public interface OrderService {
    @GetMapping("getInfo/{id}")
    public ResponseEntity<Order> getInfo(@PathVariable Long id);
}
