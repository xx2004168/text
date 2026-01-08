package com.mdxq.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private LocalDateTime orderTime;// 下单实践
    private Float totalPrice;// 总价：多个商品价格的总和
    private List<OrderItem> orderItemList;
}
