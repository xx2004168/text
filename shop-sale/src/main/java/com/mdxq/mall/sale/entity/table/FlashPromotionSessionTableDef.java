package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class FlashPromotionSessionTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final FlashPromotionSessionTableDef FLASH_PROMOTION_SESSION = new FlashPromotionSessionTableDef();

    /**
     * 编号
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 场次名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 启用状态：0->不启用；1->启用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 每日结束时间
     */
    public final QueryColumn END_TIME = new QueryColumn(this, "end_time");

    /**
     * 每日开始时间
     */
    public final QueryColumn START_TIME = new QueryColumn(this, "start_time");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, START_TIME, END_TIME, STATUS, CREATE_TIME};

    public FlashPromotionSessionTableDef() {
        super("md_mall_sale", "sms_flash_promotion_session");
    }

    private FlashPromotionSessionTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public FlashPromotionSessionTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new FlashPromotionSessionTableDef("md_mall_sale", "sms_flash_promotion_session", alias));
    }

}
