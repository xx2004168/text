package com.mdxq.mall.user.controller;

import com.mdxq.mall.entity.Message;
import com.mdxq.mall.entity.Order;
import com.mdxq.mall.entity.OrderItem;
import com.mdxq.mall.user.client.MessageService;

import com.mdxq.mall.user.client.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

// 完成远程的服务调用测试 shop-product -> 消息服务(MessageController)
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Autowired// 自动装配一个RestTemplate实例，用来进行远程的服务调用
    private RestTemplate restTemplate;

    @Autowired
    private MessageService messageService;

    @Autowired
    private OrderService orderService;

    //http://localhost:8061/api/v1/test/t2?id=10
    @GetMapping("/t2")
    public Order getOrder(Long id) {

        ResponseEntity<Order> responseEntity = orderService.getInfo(id);
        return responseEntity.getBody();
    }

    //http://localhost:8061/api/v1/test/t1?id=10
    @GetMapping("/t1")
    public Message getMessage1(Long id) {
        // 采用Feign的方式来调用远程的shop-product
        ResponseEntity<Message> responseEntity = messageService.getInfo(id);
        Message message = responseEntity.getBody();
        message.setInfo("来自Feign客户端：" + message.getInfo());
        return message;
    }

    //http://localhost:8061/api/v1/test/t0?id=10
    @GetMapping("/t0")
    public Message getMessage(Long id) {
        // 有注册中心
        String url = "http://shop-product/api/v1/message/getInfo/{id}";
        // 发送调用请求，将结果自动反序列化成一个ResponseEntity实例
        ResponseEntity<Message> responseEntity = restTemplate.getForEntity(url,Message.class,id);
        return  responseEntity.getBody();
    }
}
