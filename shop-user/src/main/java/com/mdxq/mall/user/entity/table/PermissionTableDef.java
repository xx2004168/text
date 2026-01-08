package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class PermissionTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final PermissionTableDef PERMISSION = new PermissionTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 父级权限id
     */
    public final QueryColumn PID = new QueryColumn(this, "pid");

    /**
     * 前端资源路径
     */
    public final QueryColumn URI = new QueryColumn(this, "uri");

    /**
     * 图标
     */
    public final QueryColumn ICON = new QueryColumn(this, "icon");

    /**
     * 名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 排序
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 权限值
     */
    public final QueryColumn VALUE = new QueryColumn(this, "value");

    /**
     * 启用状态；0->禁用；1->启用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PID, NAME, VALUE, ICON, TYPE, URI, STATUS, CREATE_TIME, SORT};

    public PermissionTableDef() {
        super("md_mall_user", "ums_permission");
    }

    private PermissionTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PermissionTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PermissionTableDef("md_mall_user", "ums_permission", alias));
    }

}
