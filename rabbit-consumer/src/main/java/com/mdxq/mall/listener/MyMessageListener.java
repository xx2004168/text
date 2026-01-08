package com.mdxq.mall.listener;

import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Random;

// 消息监听器：监听某个队列，当消息进入队列后执行监听方法，消费消息
//@Component
@Slf4j
public class MyMessageListener implements ChannelAwareMessageListener {
    @Autowired
    private ConnectionFactory connectionFactory;// 装配一个连接工厂
    // 注入一个连接工厂的Bean
//    @Bean("containerFactory")
    @Bean
    public SimpleRabbitListenerContainerFactory containerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();// 实例化一个容器工厂
        factory.setConnectionFactory(connectionFactory);// 设置连接工厂
        factory.setPrefetchCount(1);// 使用这个方法可以进行流量控制，一般用于高并发场景下的消息处理（削峰填谷）
        return factory;
    }

    int N = 3;// 将本来声明在方法内的 N 放在外面
    // onMessage就是监听器方法，当新消息到来时自动执行这个方法
    @Override
    @RabbitListener(queues = {"normal_queue"}, containerFactory = "containerFactory", ackMode = "MANUAL")
    public void onMessage(Message message, Channel channel) throws Exception {
        String info = "消费者X接收到新消息，内容：{}，使用的信道：{}";
        log.info(info, new String(message.getBody(), StandardCharsets.UTF_8), channel.getChannelNumber());
        // 模拟消费者处理消息的过程
        Random random = new Random();
        boolean x = false; // 将随机失败改成必然失败，任何消息都会成为死信
        try {
            if (x) { // 返回的随机布尔值如果是true表示消息消费成功,false表示失败
                // 给MQ返回一个ack的状态码，表示本条消息消费成功，无需重复发送
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
                log.info("本条消息处理成功~");
            } else {
                // 模拟消息失败的场景
                log.error("本条消息失败，需要重发~");
                throw new RuntimeException("模拟异常：消息处理出错~");
            }
        } catch (Exception ex) {
            log.info(ex.getMessage());
            if (N-- > 0) {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
            } else {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, false);
            }
        }
    }
}
