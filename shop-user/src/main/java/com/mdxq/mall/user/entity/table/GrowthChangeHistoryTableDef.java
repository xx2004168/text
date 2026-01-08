package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class GrowthChangeHistoryTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final GrowthChangeHistoryTableDef GROWTH_CHANGE_HISTORY = new GrowthChangeHistoryTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    /**
     * 改变类型：0->增加；1->减少
     */
    public final QueryColumn CHANGE_TYPE = new QueryColumn(this, "change_type");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 操作人员
     */
    public final QueryColumn OPERATE_MAN = new QueryColumn(this, "operate_man");

    /**
     * 积分来源：0->购物；1->管理员修改
     */
    public final QueryColumn SOURCE_TYPE = new QueryColumn(this, "source_type");

    /**
     * 积分改变数量
     */
    public final QueryColumn CHANGE_COUNT = new QueryColumn(this, "change_count");

    /**
     * 操作备注
     */
    public final QueryColumn OPERATE_NOTE = new QueryColumn(this, "operate_note");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_ID, CREATE_TIME, CHANGE_TYPE, CHANGE_COUNT, OPERATE_MAN, OPERATE_NOTE, SOURCE_TYPE};

    public GrowthChangeHistoryTableDef() {
        super("md_mall_user", "ums_growth_change_history");
    }

    private GrowthChangeHistoryTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public GrowthChangeHistoryTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new GrowthChangeHistoryTableDef("md_mall_user", "ums_growth_change_history", alias));
    }

}
