package com.mdxq.mall.vo;

import lombok.Data;

// 商品基本信息的Vo类， 用于在商品服务和营销服务之间传递信息
@Data
public class ProductBaseInfoVo {
    private Long id;// id
    private String name;// 商品名
    private String productSn;// 编码
    private Float price;// 价格
    private Integer stock;// 库存
}
