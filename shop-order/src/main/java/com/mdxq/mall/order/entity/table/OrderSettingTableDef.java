package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class OrderSettingTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final OrderSettingTableDef ORDER_SETTING = new OrderSettingTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 自动完成交易时间，不能申请售后（天）
     */
    public final QueryColumn FINISH_OVERTIME = new QueryColumn(this, "finish_overtime");

    /**
     * 订单完成后自动好评时间（天）
     */
    public final QueryColumn COMMENT_OVERTIME = new QueryColumn(this, "comment_overtime");

    /**
     * 发货后自动确认收货时间（天）
     */
    public final QueryColumn CONFIRM_OVERTIME = new QueryColumn(this, "confirm_overtime");

    /**
     * 秒杀订单超时关闭时间(分)
     */
    public final QueryColumn FLASH_ORDER_OVERTIME = new QueryColumn(this, "flash_order_overtime");

    /**
     * 正常订单超时时间(分)
     */
    public final QueryColumn NORMAL_ORDER_OVERTIME = new QueryColumn(this, "normal_order_overtime");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, FLASH_ORDER_OVERTIME, NORMAL_ORDER_OVERTIME, CONFIRM_OVERTIME, FINISH_OVERTIME, COMMENT_OVERTIME};

    public OrderSettingTableDef() {
        super("md_mall_order", "oms_order_setting");
    }

    private OrderSettingTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public OrderSettingTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new OrderSettingTableDef("md_mall_order", "oms_order_setting", alias));
    }

}
