package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class OrderReturnReasonTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final OrderReturnReasonTableDef ORDER_RETURN_REASON = new OrderReturnReasonTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 退货类型
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 状态：0->不启用；1->启用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 添加时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, SORT, STATUS, CREATE_TIME};

    public OrderReturnReasonTableDef() {
        super("md_mall_order", "oms_order_return_reason");
    }

    private OrderReturnReasonTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public OrderReturnReasonTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new OrderReturnReasonTableDef("md_mall_order", "oms_order_return_reason", alias));
    }

}
