package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class CommentReplayTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final CommentReplayTableDef COMMENT_REPLAY = new CommentReplayTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    
    public final QueryColumn CONTENT = new QueryColumn(this, "content");

    
    public final QueryColumn COMMENT_ID = new QueryColumn(this, "comment_id");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    
    public final QueryColumn MEMBER_ICON = new QueryColumn(this, "member_icon");

    
    public final QueryColumn MEMBER_NICK_NAME = new QueryColumn(this, "member_nick_name");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, COMMENT_ID, MEMBER_NICK_NAME, MEMBER_ICON, CONTENT, CREATE_TIME, TYPE};

    public CommentReplayTableDef() {
        super("md_mall_product", "pms_comment_replay");
    }

    private CommentReplayTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public CommentReplayTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new CommentReplayTableDef("md_mall_product", "pms_comment_replay", alias));
    }

}
