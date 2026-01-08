package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class CouponTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final CouponTableDef COUPON = new CouponTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 优惠码
     */
    public final QueryColumn CODE = new QueryColumn(this, "code");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 备注
     */
    public final QueryColumn NOTE = new QueryColumn(this, "note");

    /**
     * 优惠券类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 数量
     */
    public final QueryColumn COUNT = new QueryColumn(this, "count");

    /**
     * 金额
     */
    public final QueryColumn AMOUNT = new QueryColumn(this, "amount");

    
    public final QueryColumn END_TIME = new QueryColumn(this, "end_time");

    /**
     * 使用类型：0->全场通用；1->指定分类；2->指定商品
     */
    public final QueryColumn USE_TYPE = new QueryColumn(this, "use_type");

    /**
     * 使用门槛；0表示无门槛
     */
    public final QueryColumn MIN_POINT = new QueryColumn(this, "min_point");

    /**
     * 每人限领张数
     */
    public final QueryColumn PER_LIMIT = new QueryColumn(this, "per_limit");

    /**
     * 使用平台：0->全部；1->移动；2->PC
     */
    public final QueryColumn PLATFORM = new QueryColumn(this, "platform");

    /**
     * 已使用数量
     */
    public final QueryColumn USE_COUNT = new QueryColumn(this, "use_count");

    
    public final QueryColumn START_TIME = new QueryColumn(this, "start_time");

    /**
     * 可以领取的日期
     */
    public final QueryColumn ENABLE_TIME = new QueryColumn(this, "enable_time");

    /**
     * 可领取的会员类型：0->无限时
     */
    public final QueryColumn MEMBER_LEVEL = new QueryColumn(this, "member_level");

    /**
     * 发行数量
     */
    public final QueryColumn PUBLISH_COUNT = new QueryColumn(this, "publish_count");

    /**
     * 领取数量
     */
    public final QueryColumn RECEIVE_COUNT = new QueryColumn(this, "receive_count");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, TYPE, NAME, PLATFORM, COUNT, AMOUNT, PER_LIMIT, MIN_POINT, START_TIME, END_TIME, USE_TYPE, NOTE, PUBLISH_COUNT, USE_COUNT, RECEIVE_COUNT, ENABLE_TIME, CODE, MEMBER_LEVEL};

    public CouponTableDef() {
        super("md_mall_sale", "sms_coupon");
    }

    private CouponTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public CouponTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new CouponTableDef("md_mall_sale", "sms_coupon", alias));
    }

}
