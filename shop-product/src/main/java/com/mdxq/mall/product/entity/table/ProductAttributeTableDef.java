package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductAttributeTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductAttributeTableDef PRODUCT_ATTRIBUTE = new ProductAttributeTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 排序字段：最高的可以单独上传图片
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 属性的类型；0->规格；1->参数
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 可选值列表，以逗号隔开
     */
    public final QueryColumn INPUT_LIST = new QueryColumn(this, "input_list");

    /**
     * 属性录入方式：0->手工录入；1->从列表中选取
     */
    public final QueryColumn INPUT_TYPE = new QueryColumn(this, "input_type");

    /**
     * 分类筛选样式：1->普通；1->颜色
     */
    public final QueryColumn FILTER_TYPE = new QueryColumn(this, "filter_type");

    /**
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
     */
    public final QueryColumn SEARCH_TYPE = new QueryColumn(this, "search_type");

    /**
     * 属性选择类型：0->唯一；1->单选；2->多选
     */
    public final QueryColumn SELECT_TYPE = new QueryColumn(this, "select_type");

    /**
     * 是否支持手动新增；0->不支持；1->支持
     */
    public final QueryColumn HAND_ADD_STATUS = new QueryColumn(this, "hand_add_status");

    /**
     * 相同属性产品是否关联；0->不关联；1->关联
     */
    public final QueryColumn RELATED_STATUS = new QueryColumn(this, "related_status");

    
    public final QueryColumn PRODUCT_ATTRIBUTE_CATEGORY_ID = new QueryColumn(this, "product_attribute_category_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ATTRIBUTE_CATEGORY_ID, NAME, SELECT_TYPE, INPUT_TYPE, INPUT_LIST, SORT, FILTER_TYPE, SEARCH_TYPE, RELATED_STATUS, HAND_ADD_STATUS, TYPE};

    public ProductAttributeTableDef() {
        super("md_mall_product", "pms_product_attribute");
    }

    private ProductAttributeTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductAttributeTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductAttributeTableDef("md_mall_product", "pms_product_attribute", alias));
    }

}
