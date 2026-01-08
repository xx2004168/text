package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberMemberTagRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberMemberTagRelationTableDef MEMBER_MEMBER_TAG_RELATION = new MemberMemberTagRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn TAG_ID = new QueryColumn(this, "tag_id");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_ID, TAG_ID};

    public MemberMemberTagRelationTableDef() {
        super("md_mall_user", "ums_member_member_tag_relation");
    }

    private MemberMemberTagRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberMemberTagRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberMemberTagRelationTableDef("md_mall_user", "ums_member_member_tag_relation", alias));
    }

}
