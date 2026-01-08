package com.mdxq.mall.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig2 {
    public static final String EXCHANGE_NAME = "upbm_exchange";// 声明交换机的名字
    public static final String QUEUE_NAME = "upbm_queue";// 声明队列的名字

    @Bean("normalQueue1")
    public Queue queue() {
        return QueueBuilder
                .durable(QUEUE_NAME)
                .expires(1000 * 60 * 60 * 24)// 该队列如果连续24小时未被使用（存或取消息），将会被删除
                .ttl(60 * 1000)// 设置消息队列保存30分钟，如果在保存30分钟内未被消费自动清除
                .build();
    }
    @Bean("normalExchange1")
    public Exchange exchange() {
        // 创建一个能持久化消息的类型为主题的交换机
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }
    @Bean("binding1")
    public Binding binding(@Qualifier("normalExchange1") Exchange exchange, @Qualifier("normalQueue1") Queue queue) {
        // 将队列绑定到主题交换机上，同时指定路由键为”*.info“
        return BindingBuilder.bind(queue).to(exchange).with("person.*").noargs();
    }

}
