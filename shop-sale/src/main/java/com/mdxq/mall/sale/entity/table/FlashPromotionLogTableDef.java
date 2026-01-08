package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class FlashPromotionLogTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final FlashPromotionLogTableDef FLASH_PROMOTION_LOG = new FlashPromotionLogTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    
    public final QueryColumn SEND_TIME = new QueryColumn(this, "send_time");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn MEMBER_PHONE = new QueryColumn(this, "member_phone");

    
    public final QueryColumn PRODUCT_NAME = new QueryColumn(this, "product_name");

    /**
     * 会员订阅时间
     */
    public final QueryColumn SUBSCRIBE_TIME = new QueryColumn(this, "subscribe_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_ID, PRODUCT_ID, MEMBER_PHONE, PRODUCT_NAME, SUBSCRIBE_TIME, SEND_TIME};

    public FlashPromotionLogTableDef() {
        super("md_mall_sale", "sms_flash_promotion_log");
    }

    private FlashPromotionLogTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public FlashPromotionLogTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new FlashPromotionLogTableDef("md_mall_sale", "sms_flash_promotion_log", alias));
    }

}
