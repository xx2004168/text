package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class CommentTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final CommentTableDef COMMENT = new CommentTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 上传图片地址，以逗号隔开
     */
    public final QueryColumn PICS = new QueryColumn(this, "pics");

    /**
     * 评价星数：0->5
     */
    public final QueryColumn STAR = new QueryColumn(this, "star");

    
    public final QueryColumn CONTENT = new QueryColumn(this, "content");

    /**
     * 评价的ip
     */
    public final QueryColumn MEMBER_IP = new QueryColumn(this, "member_ip");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn READ_COUNT = new QueryColumn(this, "read_count");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 评论用户头像
     */
    public final QueryColumn MEMBER_ICON = new QueryColumn(this, "member_icon");

    
    public final QueryColumn SHOW_STATUS = new QueryColumn(this, "show_status");

    
    public final QueryColumn PRODUCT_NAME = new QueryColumn(this, "product_name");

    
    public final QueryColumn REPLAY_COUNT = new QueryColumn(this, "replay_count");

    
    public final QueryColumn COLLECT_COUONT = new QueryColumn(this, "collect_couont");

    
    public final QueryColumn MEMBER_NICK_NAME = new QueryColumn(this, "member_nick_name");

    /**
     * 购买时的商品属性
     */
    public final QueryColumn PRODUCT_ATTRIBUTE = new QueryColumn(this, "product_attribute");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, MEMBER_NICK_NAME, PRODUCT_NAME, STAR, MEMBER_IP, CREATE_TIME, SHOW_STATUS, PRODUCT_ATTRIBUTE, COLLECT_COUONT, READ_COUNT, CONTENT, PICS, MEMBER_ICON, REPLAY_COUNT};

    public CommentTableDef() {
        super("md_mall_product", "pms_comment");
    }

    private CommentTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public CommentTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new CommentTableDef("md_mall_product", "pms_comment", alias));
    }

}
