package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class AdminRoleRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final AdminRoleRelationTableDef ADMIN_ROLE_RELATION = new AdminRoleRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn ROLE_ID = new QueryColumn(this, "role_id");

    
    public final QueryColumn ADMIN_ID = new QueryColumn(this, "admin_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ADMIN_ID, ROLE_ID};

    public AdminRoleRelationTableDef() {
        super("md_mall_user", "ums_admin_role_relation");
    }

    private AdminRoleRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public AdminRoleRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new AdminRoleRelationTableDef("md_mall_user", "ums_admin_role_relation", alias));
    }

}
