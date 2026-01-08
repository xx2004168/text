package com.mdxq.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// Object Storage Service 提供本项目的 对象（文件）存储服务
@SpringBootApplication
@EnableDiscoveryClient
public class OSSApp {
    public static void main(String[] args) {
        SpringApplication.run(OSSApp.class, args);
    }
}
