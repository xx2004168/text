package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class RoleResourceRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final RoleResourceRelationTableDef ROLE_RESOURCE_RELATION = new RoleResourceRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 角色ID
     */
    public final QueryColumn ROLE_ID = new QueryColumn(this, "role_id");

    /**
     * 资源ID
     */
    public final QueryColumn RESOURCE_ID = new QueryColumn(this, "resource_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ROLE_ID, RESOURCE_ID};

    public RoleResourceRelationTableDef() {
        super("md_mall_user", "ums_role_resource_relation");
    }

    private RoleResourceRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public RoleResourceRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new RoleResourceRelationTableDef("md_mall_user", "ums_role_resource_relation", alias));
    }

}
