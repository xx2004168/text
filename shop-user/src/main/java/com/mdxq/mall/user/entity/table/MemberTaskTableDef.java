package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberTaskTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberTaskTableDef MEMBER_TASK = new MemberTaskTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 任务类型：0->新手任务；1->日常任务
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 赠送成长值
     */
    public final QueryColumn GROWTH = new QueryColumn(this, "growth");

    /**
     * 赠送积分
     */
    public final QueryColumn INTERGRATION = new QueryColumn(this, "intergration");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, GROWTH, INTERGRATION, TYPE};

    public MemberTaskTableDef() {
        super("md_mall_user", "ums_member_task");
    }

    private MemberTaskTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberTaskTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberTaskTableDef("md_mall_user", "ums_member_task", alias));
    }

}
