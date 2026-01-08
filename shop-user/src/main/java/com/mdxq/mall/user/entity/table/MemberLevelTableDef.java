package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberLevelTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberLevelTableDef MEMBER_LEVEL = new MemberLevelTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    
    public final QueryColumn NOTE = new QueryColumn(this, "note");

    
    public final QueryColumn GROWTH_POINT = new QueryColumn(this, "growth_point");

    /**
     * 是否为默认等级：0->不是；1->是
     */
    public final QueryColumn DEFAULT_STATUS = new QueryColumn(this, "default_status");

    /**
     * 免运费标准
     */
    public final QueryColumn FREE_FREIGHT_POINT = new QueryColumn(this, "free_freight_point");

    /**
     * 是否有签到特权
     */
    public final QueryColumn PRIVILEDGE_SIGN_IN = new QueryColumn(this, "priviledge_sign_in");

    /**
     * 是否有评论获奖励特权
     */
    public final QueryColumn PRIVILEDGE_COMMENT = new QueryColumn(this, "priviledge_comment");

    /**
     * 每次评价获取的成长值
     */
    public final QueryColumn COMMENT_GROWTH_POINT = new QueryColumn(this, "comment_growth_point");

    /**
     * 是否有生日特权
     */
    public final QueryColumn PRIVILEDGE_BIRTHDAY = new QueryColumn(this, "priviledge_birthday");

    /**
     * 是否有专享活动特权
     */
    public final QueryColumn PRIVILEDGE_PROMOTION = new QueryColumn(this, "priviledge_promotion");

    /**
     * 是否有免邮特权
     */
    public final QueryColumn PRIVILEDGE_FREE_FREIGHT = new QueryColumn(this, "priviledge_free_freight");

    /**
     * 是否有会员价格特权
     */
    public final QueryColumn PRIVILEDGE_MEMBER_PRICE = new QueryColumn(this, "priviledge_member_price");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, GROWTH_POINT, DEFAULT_STATUS, FREE_FREIGHT_POINT, COMMENT_GROWTH_POINT, PRIVILEDGE_FREE_FREIGHT, PRIVILEDGE_SIGN_IN, PRIVILEDGE_COMMENT, PRIVILEDGE_PROMOTION, PRIVILEDGE_MEMBER_PRICE, PRIVILEDGE_BIRTHDAY, NOTE};

    public MemberLevelTableDef() {
        super("md_mall_user", "ums_member_level");
    }

    private MemberLevelTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberLevelTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberLevelTableDef("md_mall_user", "ums_member_level", alias));
    }

}
