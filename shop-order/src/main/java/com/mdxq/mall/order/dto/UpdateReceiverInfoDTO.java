package com.mdxq.mall.order.dto;

import lombok.Data;

@Data
public class UpdateReceiverInfoDTO {
    private Long orderId;// 订单ID

    private String receiverProvince;// 省

    private String receiverCity;// 城市

    private String receiverRegion;// 区县

    private String receiverDetailAddress;// 详细地址

    private String receiverName;// 收件人名字

    private String receiverPhone;// 电话

    private String receiverPostCode;// 邮箱

    private Integer status;// 订单状态

}
