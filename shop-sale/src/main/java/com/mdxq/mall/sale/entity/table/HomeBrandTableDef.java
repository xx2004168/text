package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class HomeBrandTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final HomeBrandTableDef HOME_BRAND = new HomeBrandTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    
    public final QueryColumn BRAND_ID = new QueryColumn(this, "brand_id");

    
    public final QueryColumn BRAND_NAME = new QueryColumn(this, "brand_name");

    
    public final QueryColumn RECOMMEND_STATUS = new QueryColumn(this, "recommend_status");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, BRAND_ID, BRAND_NAME, RECOMMEND_STATUS, SORT};

    public HomeBrandTableDef() {
        super("md_mall_sale", "sms_home_brand");
    }

    private HomeBrandTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public HomeBrandTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new HomeBrandTableDef("md_mall_sale", "sms_home_brand", alias));
    }

}
