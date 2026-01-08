package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class SkuStockTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final SkuStockTableDef SKU_STOCK = new SkuStockTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 展示图片
     */
    public final QueryColumn PIC = new QueryColumn(this, "pic");

    /**
     * 销量
     */
    public final QueryColumn SALE = new QueryColumn(this, "sale");

    
    public final QueryColumn PRICE = new QueryColumn(this, "price");

    /**
     * 库存
     */
    public final QueryColumn STOCK = new QueryColumn(this, "stock");

    /**
     * 商品销售属性，json格式
     */
    public final QueryColumn SP_DATA = new QueryColumn(this, "sp_data");

    /**
     * sku编码
     */
    public final QueryColumn SKU_CODE = new QueryColumn(this, "sku_code");

    /**
     * 预警库存
     */
    public final QueryColumn LOW_STOCK = new QueryColumn(this, "low_stock");

    /**
     * 锁定库存
     */
    public final QueryColumn LOCK_STOCK = new QueryColumn(this, "lock_stock");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    /**
     * 单品促销价格
     */
    public final QueryColumn PROMOTION_PRICE = new QueryColumn(this, "promotion_price");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, SKU_CODE, PRICE, STOCK, LOW_STOCK, PIC, SALE, PROMOTION_PRICE, LOCK_STOCK, SP_DATA};

    public SkuStockTableDef() {
        super("md_mall_product", "pms_sku_stock");
    }

    private SkuStockTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public SkuStockTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new SkuStockTableDef("md_mall_product", "pms_sku_stock", alias));
    }

}
