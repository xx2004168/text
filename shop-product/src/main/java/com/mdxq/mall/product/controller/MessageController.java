package com.mdxq.mall.product.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mdxq.mall.entity.Message;
import com.mdxq.mall.product.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/message")
@Slf4j// 在控制台输出日志
public class MessageController {

    // 注入当前服务所在的端口号
    @Value("${server.port}")
    private Integer serverPort;

    @Autowired
    private MessageService messageService;

    @GetMapping("getInfo4")
    public String getInfo4(String ip) {
        return "尊贵的VIP，你好！";
    }

    @SentinelResource("R2")
    @GetMapping("getInfo3")// getInfo3?name=xxx&year=xxx
    public String getInfo(String name, int year) {
        return "Product:" + name + "," + year;
    }

    @GetMapping("getInfo/{id}")
    public ResponseEntity<Message> getInfo(@PathVariable Long id) {
        log.info("警告：有请求打进来了~");
        String info = messageService.getInfo();
        return ResponseEntity.ok(new Message(id,"商品服务",info,serverPort));
    }

    // 丁天宇
    @GetMapping("dty")
    public ResponseEntity<Message> resDty() throws InterruptedException {
        log.info("警告：有请求打进来了~");
        Random random = new Random();
        if (random.nextBoolean()) {
//            TimeUnit.SECONDS.sleep(1);
            throw new RuntimeException("程序出错了~");
        }
        return ResponseEntity.ok(new Message(1l, "商品服务", "你好, 我是丁天宇!", serverPort));
    }

    // 李海洋
    @GetMapping("lhy")
    public ResponseEntity<Message> resLhy() {
        log.info("警告：有请求打进来了~");
        return ResponseEntity.ok(new Message(1l, "商品服务", "你好, 我是李海洋!", serverPort));
    }

}
