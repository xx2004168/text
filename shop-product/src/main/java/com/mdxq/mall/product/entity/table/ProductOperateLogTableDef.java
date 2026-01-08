package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductOperateLogTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductOperateLogTableDef PRODUCT_OPERATE_LOG = new ProductOperateLogTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn PRICE_NEW = new QueryColumn(this, "price_new");

    
    public final QueryColumn PRICE_OLD = new QueryColumn(this, "price_old");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 操作人
     */
    public final QueryColumn OPERATE_MAN = new QueryColumn(this, "operate_man");

    
    public final QueryColumn GIFT_POINT_NEW = new QueryColumn(this, "gift_point_new");

    /**
     * 赠送的积分
     */
    public final QueryColumn GIFT_POINT_OLD = new QueryColumn(this, "gift_point_old");

    
    public final QueryColumn SALE_PRICE_NEW = new QueryColumn(this, "sale_price_new");

    
    public final QueryColumn SALE_PRICE_OLD = new QueryColumn(this, "sale_price_old");

    
    public final QueryColumn USE_POINT_LIMIT_NEW = new QueryColumn(this, "use_point_limit_new");

    
    public final QueryColumn USE_POINT_LIMIT_OLD = new QueryColumn(this, "use_point_limit_old");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, PRICE_OLD, PRICE_NEW, SALE_PRICE_OLD, SALE_PRICE_NEW, GIFT_POINT_OLD, GIFT_POINT_NEW, USE_POINT_LIMIT_OLD, USE_POINT_LIMIT_NEW, OPERATE_MAN, CREATE_TIME};

    public ProductOperateLogTableDef() {
        super("md_mall_product", "pms_product_operate_log");
    }

    private ProductOperateLogTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductOperateLogTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductOperateLogTableDef("md_mall_product", "pms_product_operate_log", alias));
    }

}
