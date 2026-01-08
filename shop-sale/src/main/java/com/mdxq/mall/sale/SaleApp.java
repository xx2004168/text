package com.mdxq.mall.sale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.mdxq.mall.sale.mapper")
@EnableFeignClients
@ComponentScan("com.mdxq.mall")
public class SaleApp {
    public static void main(String[] args) {
        SpringApplication.run(SaleApp.class, args);
    }
}
