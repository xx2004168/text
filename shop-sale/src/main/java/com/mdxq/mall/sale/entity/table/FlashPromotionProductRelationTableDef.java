package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class FlashPromotionProductRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final FlashPromotionProductRelationTableDef FLASH_PROMOTION_PRODUCT_RELATION = new FlashPromotionProductRelationTableDef();

    /**
     * 编号
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 排序
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn FLASH_PROMOTION_ID = new QueryColumn(this, "flash_promotion_id");

    /**
     * 限时购数量
     */
    public final QueryColumn FLASH_PROMOTION_COUNT = new QueryColumn(this, "flash_promotion_count");

    /**
     * 每人限购数量
     */
    public final QueryColumn FLASH_PROMOTION_LIMIT = new QueryColumn(this, "flash_promotion_limit");

    /**
     * 限时购价格
     */
    public final QueryColumn FLASH_PROMOTION_PRICE = new QueryColumn(this, "flash_promotion_price");

    /**
     * 编号
     */
    public final QueryColumn FLASH_PROMOTION_SESSION_ID = new QueryColumn(this, "flash_promotion_session_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, FLASH_PROMOTION_ID, FLASH_PROMOTION_SESSION_ID, PRODUCT_ID, FLASH_PROMOTION_PRICE, FLASH_PROMOTION_COUNT, FLASH_PROMOTION_LIMIT, SORT};

    public FlashPromotionProductRelationTableDef() {
        super("md_mall_sale", "sms_flash_promotion_product_relation");
    }

    private FlashPromotionProductRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public FlashPromotionProductRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new FlashPromotionProductRelationTableDef("md_mall_sale", "sms_flash_promotion_product_relation", alias));
    }

}
