package com.mdxq.mall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Long id;// 消息ID
    private String name;// 消息源
    private String info;// 消息的内容
    private Integer serverPort;// 来自于哪个端口
}
