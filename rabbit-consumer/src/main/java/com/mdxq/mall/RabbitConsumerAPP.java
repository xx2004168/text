package com.mdxq.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mdxq.mall.mapper")
public class RabbitConsumerAPP {
    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerAPP.class, args);
    }
}
