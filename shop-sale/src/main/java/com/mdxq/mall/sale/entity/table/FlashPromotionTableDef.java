package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class FlashPromotionTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final FlashPromotionTableDef FLASH_PROMOTION = new FlashPromotionTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn TITLE = new QueryColumn(this, "title");

    /**
     * 上下线状态
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 结束日期
     */
    public final QueryColumn END_DATE = new QueryColumn(this, "end_date");

    /**
     * 开始日期
     */
    public final QueryColumn START_DATE = new QueryColumn(this, "start_date");

    /**
     * 秒杀时间段名称
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, TITLE, START_DATE, END_DATE, STATUS, CREATE_TIME};

    public FlashPromotionTableDef() {
        super("md_mall_sale", "sms_flash_promotion");
    }

    private FlashPromotionTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public FlashPromotionTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new FlashPromotionTableDef("md_mall_sale", "sms_flash_promotion", alias));
    }

}
