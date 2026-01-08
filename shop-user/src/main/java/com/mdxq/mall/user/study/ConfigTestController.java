package com.mdxq.mall.user.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/config")
@RefreshScope // 就会自动监听配置中心对于属性内容的改变，无需重启服务即可获取最新的配置内容
public class ConfigTestController {
    @Value("${app.env}")
    private String appEnv; // 保存我们刚刚添加到配置中心的

    @GetMapping("/a")
    public ResponseEntity<String> a() {
        if (appEnv != null) {
            // 返回200 + 内容
            return ResponseEntity.ok("当前应用环境" + appEnv);
        } else {
            // 返回404
            return ResponseEntity.notFound().build();
        }
    }
}
