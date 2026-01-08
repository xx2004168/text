package com.mdxq.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Long id;// 10
    private String productName;// 乔丹运动鞋
    private Float price;// 899
    private Integer count;// 1
}
