package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductCategoryAttributeRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductCategoryAttributeRelationTableDef PRODUCT_CATEGORY_ATTRIBUTE_RELATION = new ProductCategoryAttributeRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn PRODUCT_CATEGORY_ID = new QueryColumn(this, "product_category_id");

    
    public final QueryColumn PRODUCT_ATTRIBUTE_ID = new QueryColumn(this, "product_attribute_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_CATEGORY_ID, PRODUCT_ATTRIBUTE_ID};

    public ProductCategoryAttributeRelationTableDef() {
        super("md_mall_product", "pms_product_category_attribute_relation");
    }

    private ProductCategoryAttributeRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductCategoryAttributeRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductCategoryAttributeRelationTableDef("md_mall_product", "pms_product_category_attribute_relation", alias));
    }

}
