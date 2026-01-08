package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class AdminPermissionRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final AdminPermissionRelationTableDef ADMIN_PERMISSION_RELATION = new AdminPermissionRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    
    public final QueryColumn ADMIN_ID = new QueryColumn(this, "admin_id");

    
    public final QueryColumn PERMISSION_ID = new QueryColumn(this, "permission_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ADMIN_ID, PERMISSION_ID, TYPE};

    public AdminPermissionRelationTableDef() {
        super("md_mall_user", "ums_admin_permission_relation");
    }

    private AdminPermissionRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public AdminPermissionRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new AdminPermissionRelationTableDef("md_mall_user", "ums_admin_permission_relation", alias));
    }

}
