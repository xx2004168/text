package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class OrderTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final OrderTableDef ORDER = new OrderTableDef();

    /**
     * 订单id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 订单备注
     */
    public final QueryColumn NOTE = new QueryColumn(this, "note");

    /**
     * 可以活动的成长值
     */
    public final QueryColumn GROWTH = new QueryColumn(this, "growth");

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 订单编号
     */
    public final QueryColumn ORDER_SN = new QueryColumn(this, "order_sn");

    /**
     * 支付方式：0->未支付；1->支付宝；2->微信
     */
    public final QueryColumn PAY_TYPE = new QueryColumn(this, "pay_type");

    /**
     * 发票类型：0->不开发票；1->电子发票；2->纸质发票
     */
    public final QueryColumn BILL_TYPE = new QueryColumn(this, "bill_type");

    
    public final QueryColumn COUPON_ID = new QueryColumn(this, "coupon_id");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    /**
     * 订单类型：0->正常订单；1->秒杀订单
     */
    public final QueryColumn ORDER_TYPE = new QueryColumn(this, "order_type");

    /**
     * 应付金额（实际支付金额）
     */
    public final QueryColumn PAY_AMOUNT = new QueryColumn(this, "pay_amount");

    /**
     * 发票抬头
     */
    public final QueryColumn BILL_HEADER = new QueryColumn(this, "bill_header");

    /**
     * 提交时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 物流单号
     */
    public final QueryColumn DELIVERY_SN = new QueryColumn(this, "delivery_sn");

    /**
     * 修改时间
     */
    public final QueryColumn MODIFY_TIME = new QueryColumn(this, "modify_time");

    /**
     * 订单来源：0->PC订单；1->app订单
     */
    public final QueryColumn SOURCE_TYPE = new QueryColumn(this, "source_type");

    /**
     * 发票内容
     */
    public final QueryColumn BILL_CONTENT = new QueryColumn(this, "bill_content");

    /**
     * 评价时间
     */
    public final QueryColumn COMMENT_TIME = new QueryColumn(this, "comment_time");

    /**
     * 可以获得的积分
     */
    public final QueryColumn INTEGRATION = new QueryColumn(this, "integration");

    /**
     * 支付时间
     */
    public final QueryColumn PAYMENT_TIME = new QueryColumn(this, "payment_time");

    /**
     * 确认收货时间
     */
    public final QueryColumn RECEIVE_TIME = new QueryColumn(this, "receive_time");

    /**
     * 订单总金额
     */
    public final QueryColumn TOTAL_AMOUNT = new QueryColumn(this, "total_amount");

    /**
     * 优惠券抵扣金额
     */
    public final QueryColumn COUPON_AMOUNT = new QueryColumn(this, "coupon_amount");

    /**
     * 删除状态：0->未删除；1->已删除
     */
    public final QueryColumn DELETE_STATUS = new QueryColumn(this, "delete_status");

    /**
     * 发货时间
     */
    public final QueryColumn DELIVERY_TIME = new QueryColumn(this, "delivery_time");

    /**
     * 城市
     */
    public final QueryColumn RECEIVER_CITY = new QueryColumn(this, "receiver_city");

    /**
     * 收货人姓名
     */
    public final QueryColumn RECEIVER_NAME = new QueryColumn(this, "receiver_name");

    /**
     * 确认收货状态：0->未确认；1->已确认
     */
    public final QueryColumn CONFIRM_STATUS = new QueryColumn(this, "confirm_status");

    /**
     * 运费金额
     */
    public final QueryColumn FREIGHT_AMOUNT = new QueryColumn(this, "freight_amount");

    /**
     * 活动信息
     */
    public final QueryColumn PROMOTION_INFO = new QueryColumn(this, "promotion_info");

    /**
     * 收货人电话
     */
    public final QueryColumn RECEIVER_PHONE = new QueryColumn(this, "receiver_phone");

    /**
     * 自动确认时间（天）
     */
    public final QueryColumn AUTO_CONFIRM_DAY = new QueryColumn(this, "auto_confirm_day");

    /**
     * 管理员后台调整订单使用的折扣金额
     */
    public final QueryColumn DISCOUNT_AMOUNT = new QueryColumn(this, "discount_amount");

    /**
     * 用户帐号
     */
    public final QueryColumn MEMBER_USERNAME = new QueryColumn(this, "member_username");

    /**
     * 区
     */
    public final QueryColumn RECEIVER_REGION = new QueryColumn(this, "receiver_region");

    /**
     * 下单时使用的积分
     */
    public final QueryColumn USE_INTEGRATION = new QueryColumn(this, "use_integration");

    /**
     * 物流公司(配送方式)
     */
    public final QueryColumn DELIVERY_COMPANY = new QueryColumn(this, "delivery_company");

    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    public final QueryColumn PROMOTION_AMOUNT = new QueryColumn(this, "promotion_amount");

    /**
     * 收货人邮编
     */
    public final QueryColumn RECEIVER_POST_CODE = new QueryColumn(this, "receiver_post_code");

    /**
     * 省份/直辖市
     */
    public final QueryColumn RECEIVER_PROVINCE = new QueryColumn(this, "receiver_province");

    /**
     * 收票人邮箱
     */
    public final QueryColumn BILL_RECEIVER_EMAIL = new QueryColumn(this, "bill_receiver_email");

    /**
     * 收票人电话
     */
    public final QueryColumn BILL_RECEIVER_PHONE = new QueryColumn(this, "bill_receiver_phone");

    /**
     * 积分抵扣金额
     */
    public final QueryColumn INTEGRATION_AMOUNT = new QueryColumn(this, "integration_amount");

    /**
     * 详细地址
     */
    public final QueryColumn RECEIVER_DETAIL_ADDRESS = new QueryColumn(this, "receiver_detail_address");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_ID, COUPON_ID, ORDER_SN, CREATE_TIME, MEMBER_USERNAME, TOTAL_AMOUNT, PAY_AMOUNT, FREIGHT_AMOUNT, PROMOTION_AMOUNT, INTEGRATION_AMOUNT, COUPON_AMOUNT, DISCOUNT_AMOUNT, PAY_TYPE, SOURCE_TYPE, STATUS, ORDER_TYPE, DELIVERY_COMPANY, DELIVERY_SN, AUTO_CONFIRM_DAY, INTEGRATION, GROWTH, PROMOTION_INFO, BILL_TYPE, BILL_HEADER, BILL_CONTENT, BILL_RECEIVER_PHONE, BILL_RECEIVER_EMAIL, RECEIVER_NAME, RECEIVER_PHONE, RECEIVER_POST_CODE, RECEIVER_PROVINCE, RECEIVER_CITY, RECEIVER_REGION, RECEIVER_DETAIL_ADDRESS, NOTE, CONFIRM_STATUS, DELETE_STATUS, USE_INTEGRATION, PAYMENT_TIME, DELIVERY_TIME, RECEIVE_TIME, COMMENT_TIME, MODIFY_TIME};

    public OrderTableDef() {
        super("md_mall_order", "oms_order");
    }

    private OrderTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public OrderTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new OrderTableDef("md_mall_order", "oms_order", alias));
    }

}
