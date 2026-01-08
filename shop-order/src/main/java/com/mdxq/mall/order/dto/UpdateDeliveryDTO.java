package com.mdxq.mall.order.dto;

import lombok.Data;

@Data
public class UpdateDeliveryDTO {
    private String deliveryCompany;// 快递公司
    private String deliverySn;// 快递单号
    private Long orderId;// 订单编号
}
