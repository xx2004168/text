package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberProductCategoryRelationTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberProductCategoryRelationTableDef MEMBER_PRODUCT_CATEGORY_RELATION = new MemberProductCategoryRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    
    public final QueryColumn PRODUCT_CATEGORY_ID = new QueryColumn(this, "product_category_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_ID, PRODUCT_CATEGORY_ID};

    public MemberProductCategoryRelationTableDef() {
        super("md_mall_user", "ums_member_product_category_relation");
    }

    private MemberProductCategoryRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberProductCategoryRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberProductCategoryRelationTableDef("md_mall_user", "ums_member_product_category_relation", alias));
    }

}
