package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberStatisticsInfoTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberStatisticsInfoTableDef MEMBER_STATISTICS_INFO = new MemberStatisticsInfoTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    /**
     * 粉丝数量
     */
    public final QueryColumn FANS_COUNT = new QueryColumn(this, "fans_count");

    /**
     * 登录次数
     */
    public final QueryColumn LOGIN_COUNT = new QueryColumn(this, "login_count");

    /**
     * 订单数量
     */
    public final QueryColumn ORDER_COUNT = new QueryColumn(this, "order_count");

    /**
     * 关注数量
     */
    public final QueryColumn ATTEND_COUNT = new QueryColumn(this, "attend_count");

    /**
     * 优惠券数量
     */
    public final QueryColumn COUPON_COUNT = new QueryColumn(this, "coupon_count");

    /**
     * 评价数
     */
    public final QueryColumn COMMENT_COUNT = new QueryColumn(this, "comment_count");

    /**
     * 累计消费金额
     */
    public final QueryColumn CONSUME_AMOUNT = new QueryColumn(this, "consume_amount");

    /**
     * 最后一次下订单时间
     */
    public final QueryColumn RECENT_ORDER_TIME = new QueryColumn(this, "recent_order_time");

    /**
     * 退货数量
     */
    public final QueryColumn RETURN_ORDER_COUNT = new QueryColumn(this, "return_order_count");

    
    public final QueryColumn COLLECT_TOPIC_COUNT = new QueryColumn(this, "collect_topic_count");

    
    public final QueryColumn INVITE_FRIEND_COUNT = new QueryColumn(this, "invite_friend_count");

    
    public final QueryColumn COLLECT_COMMENT_COUNT = new QueryColumn(this, "collect_comment_count");

    
    public final QueryColumn COLLECT_PRODUCT_COUNT = new QueryColumn(this, "collect_product_count");

    
    public final QueryColumn COLLECT_SUBJECT_COUNT = new QueryColumn(this, "collect_subject_count");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_ID, CONSUME_AMOUNT, ORDER_COUNT, COUPON_COUNT, COMMENT_COUNT, RETURN_ORDER_COUNT, LOGIN_COUNT, ATTEND_COUNT, FANS_COUNT, COLLECT_PRODUCT_COUNT, COLLECT_SUBJECT_COUNT, COLLECT_TOPIC_COUNT, COLLECT_COMMENT_COUNT, INVITE_FRIEND_COUNT, RECENT_ORDER_TIME};

    public MemberStatisticsInfoTableDef() {
        super("md_mall_user", "ums_member_statistics_info");
    }

    private MemberStatisticsInfoTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberStatisticsInfoTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberStatisticsInfoTableDef("md_mall_user", "ums_member_statistics_info", alias));
    }

}
