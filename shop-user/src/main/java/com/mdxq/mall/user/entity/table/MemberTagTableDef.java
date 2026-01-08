package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberTagTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberTagTableDef MEMBER_TAG = new MemberTagTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 自动打标签完成订单数量
     */
    public final QueryColumn FINISH_ORDER_COUNT = new QueryColumn(this, "finish_order_count");

    /**
     * 自动打标签完成订单金额
     */
    public final QueryColumn FINISH_ORDER_AMOUNT = new QueryColumn(this, "finish_order_amount");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, FINISH_ORDER_COUNT, FINISH_ORDER_AMOUNT};

    public MemberTagTableDef() {
        super("md_mall_user", "ums_member_tag");
    }

    private MemberTagTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberTagTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberTagTableDef("md_mall_user", "ums_member_tag", alias));
    }

}
