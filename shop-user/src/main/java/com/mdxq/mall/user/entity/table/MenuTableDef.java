package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MenuTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MenuTableDef MENU = new MenuTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 前端图标
     */
    public final QueryColumn ICON = new QueryColumn(this, "icon");

    /**
     * 前端名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 菜单排序
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 菜单级数
     */
    public final QueryColumn LEVEL = new QueryColumn(this, "level");

    /**
     * 菜单名称
     */
    public final QueryColumn TITLE = new QueryColumn(this, "title");

    /**
     * 前端隐藏
     */
    public final QueryColumn HIDDEN = new QueryColumn(this, "hidden");

    /**
     * 父级ID
     */
    public final QueryColumn PARENT_ID = new QueryColumn(this, "parent_id");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PARENT_ID, CREATE_TIME, TITLE, LEVEL, SORT, NAME, ICON, HIDDEN};

    public MenuTableDef() {
        super("md_mall_user", "ums_menu");
    }

    private MenuTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MenuTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MenuTableDef("md_mall_user", "ums_menu", alias));
    }

}
