package com.mdxq.mall.order.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  实体类。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "oms_order", schema = "md_mall_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    private Long memberId;

    private Long couponId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 提交时间
     */
    private LocalDateTime createTime;

    /**
     * 用户帐号
     */
    private String memberUsername;

    /**
     * 订单总金额
     */
    private Double totalAmount;

    /**
     * 应付金额（实际支付金额）
     */
    private Double payAmount;

    /**
     * 运费金额
     */
    private Double freightAmount;

    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    private Double promotionAmount;

    /**
     * 积分抵扣金额
     */
    private Double integrationAmount;

    /**
     * 优惠券抵扣金额
     */
    private Double couponAmount;

    /**
     * 管理员后台调整订单使用的折扣金额
     */
    private Double discountAmount;

    /**
     * 支付方式：0->未支付；1->支付宝；2->微信
     */
    private Integer payType;

    /**
     * 订单来源：0->PC订单；1->app订单
     */
    private Integer sourceType;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    private Integer status;

    /**
     * 订单类型：0->正常订单；1->秒杀订单
     */
    private Integer orderType;

    /**
     * 物流公司(配送方式)
     */
    private String deliveryCompany;

    /**
     * 物流单号
     */
    private String deliverySn;

    /**
     * 自动确认时间（天）
     */
    private Integer autoConfirmDay;

    /**
     * 可以获得的积分
     */
    private Integer integration;

    /**
     * 可以活动的成长值
     */
    private Integer growth;

    /**
     * 活动信息
     */
    private String promotionInfo;

    /**
     * 发票类型：0->不开发票；1->电子发票；2->纸质发票
     */
    private Integer billType;

    /**
     * 发票抬头
     */
    private String billHeader;

    /**
     * 发票内容
     */
    private String billContent;

    /**
     * 收票人电话
     */
    private String billReceiverPhone;

    /**
     * 收票人邮箱
     */
    private String billReceiverEmail;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverPhone;

    /**
     * 收货人邮编
     */
    private String receiverPostCode;

    /**
     * 省份/直辖市
     */
    private String receiverProvince;

    /**
     * 城市
     */
    private String receiverCity;

    /**
     * 区
     */
    private String receiverRegion;

    /**
     * 详细地址
     */
    private String receiverDetailAddress;

    /**
     * 订单备注
     */
    private String note;

    /**
     * 确认收货状态：0->未确认；1->已确认
     */
    private Integer confirmStatus;

    /**
     * 删除状态：0->未删除；1->已删除
     * 当调用remove方法删除订单时不执行delete SQL，而是将这个字段的值改成true（1）
     * 且查询数据时直接过滤掉此字段为1的记录
     */
    @Column(isLogicDelete = true)
    private Integer deleteStatus;

    /**
     * 下单时使用的积分
     */
    private Integer useIntegration;

    /**
     * 支付时间
     */
    private LocalDateTime paymentTime;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 确认收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 评价时间
     */
    private LocalDateTime commentTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;


    private List<OrderItem> orderItemList;

    // 用来存订单的操作历史
    private List<OrderOperateHistory> historyList;

}
