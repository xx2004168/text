package com.mdxq.mall.order.dto;

import lombok.Data;

@Data
public class UpdateNodeDTO {
    private Long id;// 订单ID
    private String note;// 备注内容
    private Integer status;// 订单状态
}
