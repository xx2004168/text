package com.mdxq.mall.listener;

import com.mdxq.mall.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(queues = "normal_queue")
@Slf4j
public class MyMessageListener2 {
//    @RabbitHandler// 当符合格式的消息到来时自动执行这个注解下的方法
    public void process(Person person) {
        String s = "消费者Y接收到新消息，内容：{}";
        log.info(s, person);
    }
}
