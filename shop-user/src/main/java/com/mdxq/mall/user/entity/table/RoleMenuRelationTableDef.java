package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class RoleMenuRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final RoleMenuRelationTableDef ROLE_MENU_RELATION = new RoleMenuRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 菜单ID
     */
    public final QueryColumn MENU_ID = new QueryColumn(this, "menu_id");

    /**
     * 角色ID
     */
    public final QueryColumn ROLE_ID = new QueryColumn(this, "role_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ROLE_ID, MENU_ID};

    public RoleMenuRelationTableDef() {
        super("md_mall_user", "ums_role_menu_relation");
    }

    private RoleMenuRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public RoleMenuRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new RoleMenuRelationTableDef("md_mall_user", "ums_role_menu_relation", alias));
    }

}
