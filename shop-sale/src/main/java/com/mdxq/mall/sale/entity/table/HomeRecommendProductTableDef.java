package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class HomeRecommendProductTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final HomeRecommendProductTableDef HOME_RECOMMEND_PRODUCT = new HomeRecommendProductTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn PRODUCT_NAME = new QueryColumn(this, "product_name");

    
    public final QueryColumn RECOMMEND_STATUS = new QueryColumn(this, "recommend_status");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, PRODUCT_NAME, RECOMMEND_STATUS, SORT};

    public HomeRecommendProductTableDef() {
        super("md_mall_sale", "sms_home_recommend_product");
    }

    private HomeRecommendProductTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public HomeRecommendProductTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new HomeRecommendProductTableDef("md_mall_sale", "sms_home_recommend_product", alias));
    }

}
