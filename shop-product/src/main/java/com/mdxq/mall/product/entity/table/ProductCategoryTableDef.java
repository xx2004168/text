package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductCategoryTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductCategoryTableDef PRODUCT_CATEGORY = new ProductCategoryTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 图标
     */
    public final QueryColumn ICON = new QueryColumn(this, "icon");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 分类级别：0->1级；1->2级
     */
    public final QueryColumn LEVEL = new QueryColumn(this, "level");

    
    public final QueryColumn KEYWORDS = new QueryColumn(this, "keywords");

    /**
     * 上机分类的编号：0表示一级分类
     */
    public final QueryColumn PARENT_ID = new QueryColumn(this, "parent_id");

    /**
     * 是否显示在导航栏：0->不显示；1->显示
     */
    public final QueryColumn NAV_STATUS = new QueryColumn(this, "nav_status");

    /**
     * 显示状态：0->不显示；1->显示
     */
    public final QueryColumn SHOW_STATUS = new QueryColumn(this, "show_status");

    /**
     * 描述
     */
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    
    public final QueryColumn PRODUCT_UNIT = new QueryColumn(this, "product_unit");

    
    public final QueryColumn PRODUCT_COUNT = new QueryColumn(this, "product_count");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PARENT_ID, NAME, LEVEL, PRODUCT_COUNT, PRODUCT_UNIT, NAV_STATUS, SHOW_STATUS, SORT, ICON, KEYWORDS, DESCRIPTION};

    public ProductCategoryTableDef() {
        super("md_mall_product", "pms_product_category");
    }

    private ProductCategoryTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductCategoryTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductCategoryTableDef("md_mall_product", "pms_product_category", alias));
    }

}
