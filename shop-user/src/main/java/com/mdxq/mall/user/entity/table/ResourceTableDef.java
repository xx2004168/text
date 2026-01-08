package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ResourceTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ResourceTableDef RESOURCE = new ResourceTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 资源URL
     */
    public final QueryColumn URL = new QueryColumn(this, "url");

    /**
     * 资源名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 资源分类ID
     */
    public final QueryColumn CATEGORY_ID = new QueryColumn(this, "category_id");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, CREATE_TIME, NAME, URL, DESCRIPTION, CATEGORY_ID};

    public ResourceTableDef() {
        super("md_mall_user", "ums_resource");
    }

    private ResourceTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ResourceTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ResourceTableDef("md_mall_user", "ums_resource", alias));
    }

}
