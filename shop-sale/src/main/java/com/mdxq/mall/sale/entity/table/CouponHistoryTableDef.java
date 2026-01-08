package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class CouponHistoryTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final CouponHistoryTableDef COUPON_HISTORY = new CouponHistoryTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 获取类型：0->后台赠送；1->主动获取
     */
    public final QueryColumn GET_TYPE = new QueryColumn(this, "get_type");

    /**
     * 订单编号
     */
    public final QueryColumn ORDER_ID = new QueryColumn(this, "order_id");

    /**
     * 订单号码
     */
    public final QueryColumn ORDER_SN = new QueryColumn(this, "order_sn");

    /**
     * 使用时间
     */
    public final QueryColumn USE_TIME = new QueryColumn(this, "use_time");

    
    public final QueryColumn COUPON_ID = new QueryColumn(this, "coupon_id");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    /**
     * 使用状态：0->未使用；1->已使用；2->已过期
     */
    public final QueryColumn USE_STATUS = new QueryColumn(this, "use_status");

    
    public final QueryColumn COUPON_CODE = new QueryColumn(this, "coupon_code");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 领取人昵称
     */
    public final QueryColumn MEMBER_NICKNAME = new QueryColumn(this, "member_nickname");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, COUPON_ID, MEMBER_ID, COUPON_CODE, MEMBER_NICKNAME, GET_TYPE, CREATE_TIME, USE_STATUS, USE_TIME, ORDER_ID, ORDER_SN};

    public CouponHistoryTableDef() {
        super("md_mall_sale", "sms_coupon_history");
    }

    private CouponHistoryTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public CouponHistoryTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new CouponHistoryTableDef("md_mall_sale", "sms_coupon_history", alias));
    }

}
