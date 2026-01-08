package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class HomeAdvertiseTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final HomeAdvertiseTableDef HOME_ADVERTISE = new HomeAdvertiseTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn PIC = new QueryColumn(this, "pic");

    /**
     * 链接地址
     */
    public final QueryColumn URL = new QueryColumn(this, "url");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 备注
     */
    public final QueryColumn NOTE = new QueryColumn(this, "note");

    /**
     * 排序
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 上下线状态：0->下线；1->上线
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    
    public final QueryColumn END_TIME = new QueryColumn(this, "end_time");

    
    public final QueryColumn START_TIME = new QueryColumn(this, "start_time");

    /**
     * 点击数
     */
    public final QueryColumn CLICK_COUNT = new QueryColumn(this, "click_count");

    /**
     * 下单数
     */
    public final QueryColumn ORDER_COUNT = new QueryColumn(this, "order_count");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, TYPE, PIC, START_TIME, END_TIME, STATUS, CLICK_COUNT, ORDER_COUNT, URL, NOTE, SORT};

    public HomeAdvertiseTableDef() {
        super("md_mall_sale", "sms_home_advertise");
    }

    private HomeAdvertiseTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public HomeAdvertiseTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new HomeAdvertiseTableDef("md_mall_sale", "sms_home_advertise", alias));
    }

}
