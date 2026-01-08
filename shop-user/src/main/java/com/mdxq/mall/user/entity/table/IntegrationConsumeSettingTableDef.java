package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class IntegrationConsumeSettingTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final IntegrationConsumeSettingTableDef INTEGRATION_CONSUME_SETTING = new IntegrationConsumeSettingTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 每次使用积分最小单位100
     */
    public final QueryColumn USE_UNIT = new QueryColumn(this, "use_unit");

    /**
     * 是否可以和优惠券同用；0->不可以；1->可以
     */
    public final QueryColumn COUPON_STATUS = new QueryColumn(this, "coupon_status");

    /**
     * 每一元需要抵扣的积分数量
     */
    public final QueryColumn DEDUCTION_PER_AMOUNT = new QueryColumn(this, "deduction_per_amount");

    /**
     * 每笔订单最高抵用百分比
     */
    public final QueryColumn MAX_PERCENT_PER_ORDER = new QueryColumn(this, "max_percent_per_order");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, DEDUCTION_PER_AMOUNT, MAX_PERCENT_PER_ORDER, USE_UNIT, COUPON_STATUS};

    public IntegrationConsumeSettingTableDef() {
        super("md_mall_user", "ums_integration_consume_setting");
    }

    private IntegrationConsumeSettingTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public IntegrationConsumeSettingTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new IntegrationConsumeSettingTableDef("md_mall_user", "ums_integration_consume_setting", alias));
    }

}
