package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class CouponProductCategoryRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final CouponProductCategoryRelationTableDef COUPON_PRODUCT_CATEGORY_RELATION = new CouponProductCategoryRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn COUPON_ID = new QueryColumn(this, "coupon_id");

    
    public final QueryColumn PRODUCT_CATEGORY_ID = new QueryColumn(this, "product_category_id");

    /**
     * 父分类名称
     */
    public final QueryColumn PARENT_CATEGORY_NAME = new QueryColumn(this, "parent_category_name");

    /**
     * 产品分类名称
     */
    public final QueryColumn PRODUCT_CATEGORY_NAME = new QueryColumn(this, "product_category_name");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, COUPON_ID, PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, PARENT_CATEGORY_NAME};

    public CouponProductCategoryRelationTableDef() {
        super("md_mall_sale", "sms_coupon_product_category_relation");
    }

    private CouponProductCategoryRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public CouponProductCategoryRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new CouponProductCategoryRelationTableDef("md_mall_sale", "sms_coupon_product_category_relation", alias));
    }

}
