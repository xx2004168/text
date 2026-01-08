package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class RoleTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final RoleTableDef ROLE = new RoleTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 启用状态：0->禁用；1->启用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 后台用户数量
     */
    public final QueryColumn ADMIN_COUNT = new QueryColumn(this, "admin_count");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 描述
     */
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, DESCRIPTION, ADMIN_COUNT, CREATE_TIME, STATUS, SORT};

    public RoleTableDef() {
        super("md_mall_user", "ums_role");
    }

    private RoleTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public RoleTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new RoleTableDef("md_mall_user", "ums_role", alias));
    }

}
