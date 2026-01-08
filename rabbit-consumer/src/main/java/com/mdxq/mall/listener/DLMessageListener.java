package com.mdxq.mall.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@RabbitListener(queues = "dlx_queue1")
@Slf4j
public class DLMessageListener {
    @RabbitHandler
    public void handle(Object message) {
        Message m = (Message) message;
        log.info("消费者【Z】接收到一条延迟消息：{}，处理完毕", new String(m.getBody(), StandardCharsets.UTF_8));
    }
}
