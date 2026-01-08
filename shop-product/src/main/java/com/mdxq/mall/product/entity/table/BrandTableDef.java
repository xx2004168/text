package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class BrandTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final BrandTableDef BRAND = new BrandTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 品牌logo
     */
    public final QueryColumn LOGO = new QueryColumn(this, "logo");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 专区大图
     */
    public final QueryColumn BIG_PIC = new QueryColumn(this, "big_pic");

    /**
     * 品牌故事
     */
    public final QueryColumn BRAND_STORY = new QueryColumn(this, "brand_story");

    
    public final QueryColumn SHOW_STATUS = new QueryColumn(this, "show_status");

    /**
     * 首字母
     */
    public final QueryColumn FIRST_LETTER = new QueryColumn(this, "first_letter");

    /**
     * 产品数量
     */
    public final QueryColumn PRODUCT_COUNT = new QueryColumn(this, "product_count");

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    public final QueryColumn FACTORY_STATUS = new QueryColumn(this, "factory_status");

    /**
     * 产品评论数量
     */
    public final QueryColumn PRODUCT_COMMENT_COUNT = new QueryColumn(this, "product_comment_count");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, FIRST_LETTER, SORT, FACTORY_STATUS, SHOW_STATUS, PRODUCT_COUNT, PRODUCT_COMMENT_COUNT, LOGO, BIG_PIC, BRAND_STORY};

    public BrandTableDef() {
        super("md_mall_product", "pms_brand");
    }

    private BrandTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public BrandTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new BrandTableDef("md_mall_product", "pms_brand", alias));
    }

}
