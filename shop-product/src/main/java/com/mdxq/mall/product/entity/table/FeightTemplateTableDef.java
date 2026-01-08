package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class FeightTemplateTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final FeightTemplateTableDef FEIGHT_TEMPLATE = new FeightTemplateTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 目的地（省、市）
     */
    public final QueryColumn DEST = new QueryColumn(this, "dest");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 首费（元）
     */
    public final QueryColumn FIRST_FEE = new QueryColumn(this, "first_fee");

    /**
     * 计费类型:0->按重量；1->按件数
     */
    public final QueryColumn CHARGE_TYPE = new QueryColumn(this, "charge_type");

    
    public final QueryColumn CONTINME_FEE = new QueryColumn(this, "continme_fee");

    /**
     * 首重kg
     */
    public final QueryColumn FIRST_WEIGHT = new QueryColumn(this, "first_weight");

    
    public final QueryColumn CONTINUE_WEIGHT = new QueryColumn(this, "continue_weight");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, CHARGE_TYPE, FIRST_WEIGHT, FIRST_FEE, CONTINUE_WEIGHT, CONTINME_FEE, DEST};

    public FeightTemplateTableDef() {
        super("md_mall_product", "pms_feight_template");
    }

    private FeightTemplateTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public FeightTemplateTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new FeightTemplateTableDef("md_mall_product", "pms_feight_template", alias));
    }

}
