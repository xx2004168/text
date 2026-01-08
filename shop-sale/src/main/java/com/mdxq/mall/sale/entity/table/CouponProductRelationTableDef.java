package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class CouponProductRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final CouponProductRelationTableDef COUPON_PRODUCT_RELATION = new CouponProductRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn COUPON_ID = new QueryColumn(this, "coupon_id");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    /**
     * 商品编码
     */
    public final QueryColumn PRODUCT_SN = new QueryColumn(this, "product_sn");

    /**
     * 商品名称
     */
    public final QueryColumn PRODUCT_NAME = new QueryColumn(this, "product_name");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, COUPON_ID, PRODUCT_ID, PRODUCT_NAME, PRODUCT_SN};

    public CouponProductRelationTableDef() {
        super("md_mall_sale", "sms_coupon_product_relation");
    }

    private CouponProductRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public CouponProductRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new CouponProductRelationTableDef("md_mall_sale", "sms_coupon_product_relation", alias));
    }

}
