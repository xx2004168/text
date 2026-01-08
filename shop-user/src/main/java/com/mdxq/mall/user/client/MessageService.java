package com.mdxq.mall.user.client;

import com.mdxq.mall.entity.Message;
import com.mdxq.mall.user.client.fallback.MessageServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 声明当shop-product服务不可用时，默认执行MessageServiceFallback类中的方法返回结果，不在等待
@FeignClient(value = "shop-product", fallback = MessageServiceFallback.class)
//@RequestMapping("/api/v1/message")
public interface MessageService {

    @GetMapping("/api/v1/message/getInfo/{id}")
    public ResponseEntity<Message> getInfo(@PathVariable Long id);

}
