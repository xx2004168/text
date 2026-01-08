package com.mdxq.mall.sale.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class HomeRecommendSubjectTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final HomeRecommendSubjectTableDef HOME_RECOMMEND_SUBJECT = new HomeRecommendSubjectTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    
    public final QueryColumn SUBJECT_ID = new QueryColumn(this, "subject_id");

    
    public final QueryColumn SUBJECT_NAME = new QueryColumn(this, "subject_name");

    
    public final QueryColumn RECOMMEND_STATUS = new QueryColumn(this, "recommend_status");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, SUBJECT_ID, SUBJECT_NAME, RECOMMEND_STATUS, SORT};

    public HomeRecommendSubjectTableDef() {
        super("md_mall_sale", "sms_home_recommend_subject");
    }

    private HomeRecommendSubjectTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public HomeRecommendSubjectTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new HomeRecommendSubjectTableDef("md_mall_sale", "sms_home_recommend_subject", alias));
    }

}
