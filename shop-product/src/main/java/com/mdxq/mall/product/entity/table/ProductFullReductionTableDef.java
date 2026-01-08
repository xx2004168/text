package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductFullReductionTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductFullReductionTableDef PRODUCT_FULL_REDUCTION = new ProductFullReductionTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn FULL_PRICE = new QueryColumn(this, "full_price");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn REDUCE_PRICE = new QueryColumn(this, "reduce_price");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, FULL_PRICE, REDUCE_PRICE};

    public ProductFullReductionTableDef() {
        super("md_mall_product", "pms_product_full_reduction");
    }

    private ProductFullReductionTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductFullReductionTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductFullReductionTableDef("md_mall_product", "pms_product_full_reduction", alias));
    }

}
