package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class ProductTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final ProductTableDef PRODUCT = new ProductTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn PIC = new QueryColumn(this, "pic");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    
    public final QueryColumn NOTE = new QueryColumn(this, "note");

    /**
     * 销量
     */
    public final QueryColumn SALE = new QueryColumn(this, "sale");

    /**
     * 排序
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 单位
     */
    public final QueryColumn UNIT = new QueryColumn(this, "unit");

    
    public final QueryColumn PRICE = new QueryColumn(this, "price");

    /**
     * 库存
     */
    public final QueryColumn STOCK = new QueryColumn(this, "stock");

    /**
     * 商品重量，默认为克
     */
    public final QueryColumn WEIGHT = new QueryColumn(this, "weight");

    
    public final QueryColumn BRAND_ID = new QueryColumn(this, "brand_id");

    
    public final QueryColumn KEYWORDS = new QueryColumn(this, "keywords");

    /**
     * 库存预警值
     */
    public final QueryColumn LOW_STOCK = new QueryColumn(this, "low_stock");

    /**
     * 副标题
     */
    public final QueryColumn SUB_TITLE = new QueryColumn(this, "sub_title");

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     */
    public final QueryColumn ALBUM_PICS = new QueryColumn(this, "album_pics");

    /**
     * 品牌名称
     */
    public final QueryColumn BRAND_NAME = new QueryColumn(this, "brand_name");

    /**
     * 赠送的积分
     */
    public final QueryColumn GIFT_POINT = new QueryColumn(this, "gift_point");

    /**
     * 新品状态:0->不是新品；1->新品
     */
    public final QueryColumn NEW_STATUS = new QueryColumn(this, "new_status");

    /**
     * 货号
     */
    public final QueryColumn PRODUCT_SN = new QueryColumn(this, "product_sn");

    
    public final QueryColumn DETAIL_DESC = new QueryColumn(this, "detail_desc");

    /**
     * 产品详情网页内容
     */
    public final QueryColumn DETAIL_HTML = new QueryColumn(this, "detail_html");

    /**
     * 赠送的成长值
     */
    public final QueryColumn GIFT_GROWTH = new QueryColumn(this, "gift_growth");

    /**
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    public final QueryColumn SERVICE_IDS = new QueryColumn(this, "service_ids");

    /**
     * 商品描述
     */
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    
    public final QueryColumn DETAIL_TITLE = new QueryColumn(this, "detail_title");

    /**
     * 删除状态：0->未删除；1->已删除
     */
    public final QueryColumn DELETE_STATUS = new QueryColumn(this, "delete_status");

    /**
     * 审核状态：0->未审核；1->审核通过
     */
    public final QueryColumn VERIFY_STATUS = new QueryColumn(this, "verify_status");

    /**
     * 市场价
     */
    public final QueryColumn ORIGINAL_PRICE = new QueryColumn(this, "original_price");

    /**
     * 是否为预告商品：0->不是；1->是
     */
    public final QueryColumn PREVIEW_STATUS = new QueryColumn(this, "preview_status");

    /**
     * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
     */
    public final QueryColumn PROMOTION_TYPE = new QueryColumn(this, "promotion_type");

    /**
     * 上架状态：0->下架；1->上架
     */
    public final QueryColumn PUBLISH_STATUS = new QueryColumn(this, "publish_status");

    /**
     * 限制使用的积分数
     */
    public final QueryColumn USE_POINT_LIMIT = new QueryColumn(this, "use_point_limit");

    /**
     * 促销价格
     */
    public final QueryColumn PROMOTION_PRICE = new QueryColumn(this, "promotion_price");

    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    public final QueryColumn RECOMMAND_STATUS = new QueryColumn(this, "recommand_status");

    /**
     * 移动端网页详情
     */
    public final QueryColumn DETAIL_MOBILE_HTML = new QueryColumn(this, "detail_mobile_html");

    
    public final QueryColumn FEIGHT_TEMPLATE_ID = new QueryColumn(this, "feight_template_id");

    /**
     * 促销结束时间
     */
    public final QueryColumn PROMOTION_END_TIME = new QueryColumn(this, "promotion_end_time");

    
    public final QueryColumn PRODUCT_CATEGORY_ID = new QueryColumn(this, "product_category_id");

    /**
     * 活动限购数量
     */
    public final QueryColumn PROMOTION_PER_LIMIT = new QueryColumn(this, "promotion_per_limit");

    /**
     * 促销开始时间
     */
    public final QueryColumn PROMOTION_START_TIME = new QueryColumn(this, "promotion_start_time");

    /**
     * 商品分类名称
     */
    public final QueryColumn PRODUCT_CATEGORY_NAME = new QueryColumn(this, "product_category_name");

    
    public final QueryColumn PRODUCT_ATTRIBUTE_CATEGORY_ID = new QueryColumn(this, "product_attribute_category_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, BRAND_ID, PRODUCT_CATEGORY_ID, FEIGHT_TEMPLATE_ID, PRODUCT_ATTRIBUTE_CATEGORY_ID, NAME, PIC, PRODUCT_SN, DELETE_STATUS, PUBLISH_STATUS, NEW_STATUS, RECOMMAND_STATUS, VERIFY_STATUS, SORT, SALE, PRICE, PROMOTION_PRICE, GIFT_GROWTH, GIFT_POINT, USE_POINT_LIMIT, SUB_TITLE, DESCRIPTION, ORIGINAL_PRICE, STOCK, LOW_STOCK, UNIT, WEIGHT, PREVIEW_STATUS, SERVICE_IDS, KEYWORDS, NOTE, ALBUM_PICS, DETAIL_TITLE, DETAIL_DESC, DETAIL_HTML, DETAIL_MOBILE_HTML, PROMOTION_START_TIME, PROMOTION_END_TIME, PROMOTION_PER_LIMIT, PROMOTION_TYPE, BRAND_NAME, PRODUCT_CATEGORY_NAME};

    public ProductTableDef() {
        super("md_mall_product", "pms_product");
    }

    private ProductTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public ProductTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new ProductTableDef("md_mall_product", "pms_product", alias));
    }

}
