package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class OrderReturnApplyTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final OrderReturnApplyTableDef ORDER_RETURN_APPLY = new OrderReturnApplyTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 原因
     */
    public final QueryColumn REASON = new QueryColumn(this, "reason");

    /**
     * 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 订单id
     */
    public final QueryColumn ORDER_ID = new QueryColumn(this, "order_id");

    /**
     * 订单编号
     */
    public final QueryColumn ORDER_SN = new QueryColumn(this, "order_sn");

    /**
     * 处理人员
     */
    public final QueryColumn HANDLE_MAN = new QueryColumn(this, "handle_man");

    /**
     * 退货商品id
     */
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    /**
     * 凭证图片，以逗号隔开
     */
    public final QueryColumn PROOF_PICS = new QueryColumn(this, "proof_pics");

    /**
     * 申请时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 处理备注
     */
    public final QueryColumn HANDLE_NOTE = new QueryColumn(this, "handle_note");

    /**
     * 处理时间
     */
    public final QueryColumn HANDLE_TIME = new QueryColumn(this, "handle_time");

    /**
     * 商品图片
     */
    public final QueryColumn PRODUCT_PIC = new QueryColumn(this, "product_pic");

    /**
     * 收货人
     */
    public final QueryColumn RECEIVE_MAN = new QueryColumn(this, "receive_man");

    /**
     * 退货人姓名
     */
    public final QueryColumn RETURN_NAME = new QueryColumn(this, "return_name");

    /**
     * 描述
     */
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    /**
     * 商品销售属性：颜色：红色；尺码：xl;
     */
    public final QueryColumn PRODUCT_ATTR = new QueryColumn(this, "product_attr");

    /**
     * 商品名称
     */
    public final QueryColumn PRODUCT_NAME = new QueryColumn(this, "product_name");

    /**
     * 收货备注
     */
    public final QueryColumn RECEIVE_NOTE = new QueryColumn(this, "receive_note");

    /**
     * 收货时间
     */
    public final QueryColumn RECEIVE_TIME = new QueryColumn(this, "receive_time");

    /**
     * 退货人电话
     */
    public final QueryColumn RETURN_PHONE = new QueryColumn(this, "return_phone");

    /**
     * 商品品牌
     */
    public final QueryColumn PRODUCT_BRAND = new QueryColumn(this, "product_brand");

    /**
     * 退货数量
     */
    public final QueryColumn PRODUCT_COUNT = new QueryColumn(this, "product_count");

    /**
     * 商品单价
     */
    public final QueryColumn PRODUCT_PRICE = new QueryColumn(this, "product_price");

    /**
     * 退款金额
     */
    public final QueryColumn RETURN_AMOUNT = new QueryColumn(this, "return_amount");

    /**
     * 会员用户名
     */
    public final QueryColumn MEMBER_USERNAME = new QueryColumn(this, "member_username");

    /**
     * 收货地址表id
     */
    public final QueryColumn COMPANY_ADDRESS_ID = new QueryColumn(this, "company_address_id");

    /**
     * 商品实际支付单价
     */
    public final QueryColumn PRODUCT_REAL_PRICE = new QueryColumn(this, "product_real_price");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ORDER_ID, COMPANY_ADDRESS_ID, PRODUCT_ID, ORDER_SN, CREATE_TIME, MEMBER_USERNAME, RETURN_AMOUNT, RETURN_NAME, RETURN_PHONE, STATUS, HANDLE_TIME, PRODUCT_PIC, PRODUCT_NAME, PRODUCT_BRAND, PRODUCT_ATTR, PRODUCT_COUNT, PRODUCT_PRICE, PRODUCT_REAL_PRICE, REASON, DESCRIPTION, PROOF_PICS, HANDLE_NOTE, HANDLE_MAN, RECEIVE_MAN, RECEIVE_TIME, RECEIVE_NOTE};

    public OrderReturnApplyTableDef() {
        super("md_mall_order", "oms_order_return_apply");
    }

    private OrderReturnApplyTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public OrderReturnApplyTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new OrderReturnApplyTableDef("md_mall_order", "oms_order_return_apply", alias));
    }

}
