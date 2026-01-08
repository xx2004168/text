package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductLadderTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductLadderTableDef PRODUCT_LADDER = new ProductLadderTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 满足的商品数量
     */
    public final QueryColumn COUNT = new QueryColumn(this, "count");

    /**
     * 折后价格
     */
    public final QueryColumn PRICE = new QueryColumn(this, "price");

    /**
     * 折扣
     */
    public final QueryColumn DISCOUNT = new QueryColumn(this, "discount");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, COUNT, DISCOUNT, PRICE};

    public ProductLadderTableDef() {
        super("md_mall_product", "pms_product_ladder");
    }

    private ProductLadderTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductLadderTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductLadderTableDef("md_mall_product", "pms_product_ladder", alias));
    }

}
