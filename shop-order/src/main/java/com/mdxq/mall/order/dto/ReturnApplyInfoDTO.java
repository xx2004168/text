package com.mdxq.mall.order.dto;

import lombok.Data;

// 保存确认收货信息
@Data
public class ReturnApplyInfoDTO {
    private String handleMan;
    private String handleNote;
    private String receiveMan;
    private String receiveNote;
    private Float returnAmount;
    private Integer status;
    private Long companyAddressId;
}
