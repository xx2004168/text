package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ResourceCategoryTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ResourceCategoryTableDef RESOURCE_CATEGORY = new ResourceCategoryTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 分类名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 排序
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, CREATE_TIME, NAME, SORT};

    public ResourceCategoryTableDef() {
        super("md_mall_user", "ums_resource_category");
    }

    private ResourceCategoryTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ResourceCategoryTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ResourceCategoryTableDef("md_mall_user", "ums_resource_category", alias));
    }

}
