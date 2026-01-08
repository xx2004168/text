package com.mdxq.mall.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE_NAME = "normal_exchange";// 声明交换机的名字
    public static final String QUEUE_NAME = "normal_queue";// 声明队列的名字
    public static final String DLX_EXCHANGE_NAME = "dlx_exchange1";// 死信交换机的名称
    public static final String DLX_QUEUE_NAME = "dlx_queue1";// 死信队列的名称

    // 分别创建死信交换机和死信队列的bean
    @Bean("dlxExchange1")
    public Exchange dlxExchange() {
        return ExchangeBuilder.topicExchange(DLX_EXCHANGE_NAME)
                .durable(true)
                .build();
    }
    @Bean("dlxQueue1")
    public Queue dlxQueue() {
        return QueueBuilder.durable(DLX_QUEUE_NAME).build();
    }
    @Bean
    public Binding dlxBinding1(@Qualifier("dlxQueue1") Queue queue, @Qualifier("dlxExchange1") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("dlx.*").noargs();
    }
    @Bean("normalQueue")
    public Queue queue() {
        return QueueBuilder
                .durable(QUEUE_NAME)
                .expires(1000 * 60 * 60 * 24)// 该队列如果连续24小时未被使用（存或取消息），将会被删除
                .ttl(10 * 1000)// 设置消息队列保存30分钟，如果在保存30分钟内未被消费自动清除
                .deadLetterExchange(DLX_EXCHANGE_NAME )// 指定当前队列的死信队列
                .deadLetterRoutingKey("dlx.info")// 死信的路由键
                .build();
    }
    @Bean("normalExchange")
    public Exchange exchange() {
        // 创建一个能持久化消息的类型为主题的交换机
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }
    @Bean
    public Binding binding(@Qualifier("normalExchange") Exchange exchange, @Qualifier("normalQueue") Queue queue) {
        // 将队列绑定到主题交换机上，同时指定路由键为”*.info“
        return BindingBuilder.bind(queue).to(exchange).with("*.info").noargs();
    }

}
