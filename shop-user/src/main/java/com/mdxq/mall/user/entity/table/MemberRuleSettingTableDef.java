package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberRuleSettingTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberRuleSettingTableDef MEMBER_RULE_SETTING = new MemberRuleSettingTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 类型：0->积分规则；1->成长值规则
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 最低获取点数的订单金额
     */
    public final QueryColumn LOW_ORDER_AMOUNT = new QueryColumn(this, "low_order_amount");

    /**
     * 每消费多少元获取1个点
     */
    public final QueryColumn CONSUME_PER_POINT = new QueryColumn(this, "consume_per_point");

    /**
     * 连续签到天数
     */
    public final QueryColumn CONTINUE_SIGN_DAY = new QueryColumn(this, "continue_sign_day");

    /**
     * 每笔订单最高获取点数
     */
    public final QueryColumn MAX_POINT_PER_ORDER = new QueryColumn(this, "max_point_per_order");

    /**
     * 连续签到赠送数量
     */
    public final QueryColumn CONTINUE_SIGN_POINT = new QueryColumn(this, "continue_sign_point");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, CONTINUE_SIGN_DAY, CONTINUE_SIGN_POINT, CONSUME_PER_POINT, LOW_ORDER_AMOUNT, MAX_POINT_PER_ORDER, TYPE};

    public MemberRuleSettingTableDef() {
        super("md_mall_user", "ums_member_rule_setting");
    }

    private MemberRuleSettingTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberRuleSettingTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberRuleSettingTableDef("md_mall_user", "ums_member_rule_setting", alias));
    }

}
