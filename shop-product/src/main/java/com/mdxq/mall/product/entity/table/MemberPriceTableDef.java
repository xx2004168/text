package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberPriceTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberPriceTableDef MEMBER_PRICE = new MemberPriceTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    /**
     * 会员价格
     */
    public final QueryColumn MEMBER_PRICE_COL = new QueryColumn(this, "member_price");

    
    public final QueryColumn MEMBER_LEVEL_ID = new QueryColumn(this, "member_level_id");

    
    public final QueryColumn MEMBER_LEVEL_NAME = new QueryColumn(this, "member_level_name");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, MEMBER_LEVEL_ID, MEMBER_PRICE_COL, MEMBER_LEVEL_NAME};

    public MemberPriceTableDef() {
        super("md_mall_product", "pms_member_price");
    }

    private MemberPriceTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberPriceTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberPriceTableDef("md_mall_product", "pms_member_price", alias));
    }

}
