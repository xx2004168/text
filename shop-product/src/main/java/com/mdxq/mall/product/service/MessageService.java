package com.mdxq.mall.product.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @SentinelResource("R1")
    public String getInfo() {
        return "重要信息......";
    }

}
