package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductAttributeCategoryTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductAttributeCategoryTableDef PRODUCT_ATTRIBUTE_CATEGORY = new ProductAttributeCategoryTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 参数数量
     */
    public final QueryColumn PARAM_COUNT = new QueryColumn(this, "param_count");

    /**
     * 属性数量
     */
    public final QueryColumn ATTRIBUTE_COUNT = new QueryColumn(this, "attribute_count");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, ATTRIBUTE_COUNT, PARAM_COUNT};

    public ProductAttributeCategoryTableDef() {
        super("md_mall_product", "pms_product_attribute_category");
    }

    private ProductAttributeCategoryTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductAttributeCategoryTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductAttributeCategoryTableDef("md_mall_product", "pms_product_attribute_category", alias));
    }

}
