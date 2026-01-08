package com.mdxq.mall.controller;

import com.mdxq.mall.config.RabbitConfig;
import com.mdxq.mall.config.RabbitConfig2;
import com.mdxq.mall.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

// 借助web客户端，向队列中生产各式各样的消息
@RestController
@RequestMapping("/rabbit")
@Slf4j
public class RabbitController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("updateBalance")
    public String updateBalance(@RequestBody Person person) {
        rabbitTemplate.convertAndSend(RabbitConfig2.EXCHANGE_NAME, "person.balance", person);
        return "Success~";
    }

    @PostMapping("sendMessage1")
    public String t1(@RequestParam String message) {
        // routingKey 可以时队列的名称，也可以是路由键
        rabbitTemplate.send("normal_queue", new Message(message.getBytes(StandardCharsets.UTF_8)));
//        rabbitTemplate.send("user.info", new Message(message.getBytes(StandardCharsets.UTF_8)));

        return "Success~";
    }

    @PostMapping("sendMessage2")
    public String t2(@RequestParam String message) {
        // 使用【主题】交换机和路由键进行消息投递，选择放到哪个队列里
        rabbitTemplate.send(RabbitConfig.EXCHANGE_NAME, "user.info",
                new Message(message.getBytes(StandardCharsets.UTF_8)));
        return "Success~";
    }

    @PostMapping("sendMessage3")
    public String t3(@RequestBody Person person) {
        // convertAndSend可以将任意类型的数据转换格式后投递到消息队列
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "user.info", person);
        return "Success~";
    }

    // 第一种保证消息可靠性投递的方式(confirm模式)，生产端通过确认ACK状态码来判断是否需要重传本消息
    @PostMapping("sendMessage4")
    public String t4(@RequestParam String message) {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            // 参数说明：1.消息的唯一标识 2.消息是否成功投递到mq 3.如果未成功，保存失败的原因
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                // ack如果为true，则什么也不做，繁殖则重传此消息
                if (! ack) {
                    rabbitTemplate.send(RabbitConfig.EXCHANGE_NAME, "user.info",
                            new Message(message.getBytes(StandardCharsets.UTF_8)), correlationData);
                }

            }
        });
        rabbitTemplate.send(RabbitConfig.EXCHANGE_NAME, "user.info",
                new Message(message.getBytes(StandardCharsets.UTF_8)), new CorrelationData("101"));
        return "Success~";
    }

    // 第二种保证消息可靠性投递的方式(return模式)，生产端通过调用returnCallback方法来重发消息
    @PostMapping("sendMessage5")
    public String t5(@RequestParam String message) {
        rabbitTemplate.setMandatory(true);// 强制性可靠性消息投递
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            // 参数说明：1.正在发送的消息 2.（MQ返回的）状态码 3.（MQ返回的）状态文本 4.交换机的名称 5.路由键
            // 如果消息从交换机投递到队列的过程中出现了故障，就会自动回调 returnMessage 方法
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("消息内容：{}", new String(message.getBody(), StandardCharsets.UTF_8));
                log.info("MQ返回的状态码：{}", replyCode);
                log.info("MQ返回的状态文本：{}", replyText);
                log.info("交换机的名称：{}", exchange);
                log.info("路由键：{}", routingKey);
                rabbitTemplate.send(exchange, routingKey, message);// 重传这条消息
            }
        });
        rabbitTemplate.send(RabbitConfig.EXCHANGE_NAME, "user.info",
                new Message(message.getBytes(StandardCharsets.UTF_8)));
        return "Success~";
    }
}
