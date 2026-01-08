package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class OrderOperateHistoryTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final OrderOperateHistoryTableDef ORDER_OPERATE_HISTORY = new OrderOperateHistoryTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 备注
     */
    public final QueryColumn NOTE = new QueryColumn(this, "note");

    /**
     * 订单id
     */
    public final QueryColumn ORDER_ID = new QueryColumn(this, "order_id");

    /**
     * 操作时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 操作人：用户；系统；后台管理员
     */
    public final QueryColumn OPERATE_MAN = new QueryColumn(this, "operate_man");

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    public final QueryColumn ORDER_STATUS = new QueryColumn(this, "order_status");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ORDER_ID, OPERATE_MAN, CREATE_TIME, ORDER_STATUS, NOTE};

    public OrderOperateHistoryTableDef() {
        super("md_mall_order", "oms_order_operate_history");
    }

    private OrderOperateHistoryTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public OrderOperateHistoryTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new OrderOperateHistoryTableDef("md_mall_order", "oms_order_operate_history", alias));
    }

}
