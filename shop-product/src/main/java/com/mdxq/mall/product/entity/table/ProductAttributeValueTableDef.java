package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductAttributeValueTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductAttributeValueTableDef PRODUCT_ATTRIBUTE_VALUE = new ProductAttributeValueTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
     */
    public final QueryColumn VALUE = new QueryColumn(this, "value");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn PRODUCT_ATTRIBUTE_ID = new QueryColumn(this, "product_attribute_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, PRODUCT_ATTRIBUTE_ID, VALUE};

    public ProductAttributeValueTableDef() {
        super("md_mall_product", "pms_product_attribute_value");
    }

    private ProductAttributeValueTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductAttributeValueTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductAttributeValueTableDef("md_mall_product", "pms_product_attribute_value", alias));
    }

}
