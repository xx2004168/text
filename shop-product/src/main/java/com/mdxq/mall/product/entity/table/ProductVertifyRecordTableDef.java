package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductVertifyRecordTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductVertifyRecordTableDef PRODUCT_VERTIFY_RECORD = new ProductVertifyRecordTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 反馈详情
     */
    public final QueryColumn DETAIL = new QueryColumn(this, "detail");

    
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 审核人
     */
    public final QueryColumn VERTIFY_MAN = new QueryColumn(this, "vertify_man");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, CREATE_TIME, VERTIFY_MAN, STATUS, DETAIL};

    public ProductVertifyRecordTableDef() {
        super("md_mall_product", "pms_product_vertify_record");
    }

    private ProductVertifyRecordTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductVertifyRecordTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductVertifyRecordTableDef("md_mall_product", "pms_product_vertify_record", alias));
    }

}
