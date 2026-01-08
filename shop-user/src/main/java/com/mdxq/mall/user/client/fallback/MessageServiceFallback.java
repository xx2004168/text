package com.mdxq.mall.user.client.fallback;

import com.mdxq.mall.entity.Message;
import com.mdxq.mall.user.client.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceFallback implements MessageService {
    @Override
    public ResponseEntity<Message> getInfo(Long id) {
        return ResponseEntity.ok(
                new Message(-1L,null,"商品服务被熔断，返回一个默认的Message！！！！",-1)
        );
    }
}
