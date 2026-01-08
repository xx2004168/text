package com.mdxq.mall.order.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OrderSearchDTO {
    private String orderSn;// 订单编号
    private String receiverKeyword;// 收件人关键字，姓名/手机号
    private Integer status;// 订单状态
    private Integer orderType;// 订单类型：普通订单/秒杀订单
    private Integer sourceType;// 订单来源：PC/APP
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime;// 创建时间

}
