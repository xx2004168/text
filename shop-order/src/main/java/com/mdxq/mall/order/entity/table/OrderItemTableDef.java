package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class OrderItemTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final OrderItemTableDef ORDER_ITEM = new OrderItemTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 订单id
     */
    public final QueryColumn ORDER_ID = new QueryColumn(this, "order_id");

    /**
     * 订单编号
     */
    public final QueryColumn ORDER_SN = new QueryColumn(this, "order_sn");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn PRODUCT_SN = new QueryColumn(this, "product_sn");

    
    public final QueryColumn GIFT_GROWTH = new QueryColumn(this, "gift_growth");

    
    public final QueryColumn PRODUCT_PIC = new QueryColumn(this, "product_pic");

    /**
     * 该商品经过优惠后的分解金额
     */
    public final QueryColumn REAL_AMOUNT = new QueryColumn(this, "real_amount");

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    public final QueryColumn PRODUCT_ATTR = new QueryColumn(this, "product_attr");

    
    public final QueryColumn PRODUCT_NAME = new QueryColumn(this, "product_name");

    /**
     * 优惠券优惠分解金额
     */
    public final QueryColumn COUPON_AMOUNT = new QueryColumn(this, "coupon_amount");

    
    public final QueryColumn PRODUCT_BRAND = new QueryColumn(this, "product_brand");

    /**
     * 销售价格
     */
    public final QueryColumn PRODUCT_PRICE = new QueryColumn(this, "product_price");

    /**
     * 商品sku编号
     */
    public final QueryColumn PRODUCT_SKU_ID = new QueryColumn(this, "product_sku_id");

    /**
     * 商品促销名称
     */
    public final QueryColumn PROMOTION_NAME = new QueryColumn(this, "promotion_name");

    /**
     * 商品sku条码
     */
    public final QueryColumn PRODUCT_SKU_CODE = new QueryColumn(this, "product_sku_code");

    
    public final QueryColumn GIFT_INTEGRATION = new QueryColumn(this, "gift_integration");

    /**
     * 购买数量
     */
    public final QueryColumn PRODUCT_QUANTITY = new QueryColumn(this, "product_quantity");

    /**
     * 商品促销分解金额
     */
    public final QueryColumn PROMOTION_AMOUNT = new QueryColumn(this, "promotion_amount");

    /**
     * 积分优惠分解金额
     */
    public final QueryColumn INTEGRATION_AMOUNT = new QueryColumn(this, "integration_amount");

    /**
     * 商品分类id
     */
    public final QueryColumn PRODUCT_CATEGORY_ID = new QueryColumn(this, "product_category_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ORDER_ID, ORDER_SN, PRODUCT_ID, PRODUCT_PIC, PRODUCT_NAME, PRODUCT_BRAND, PRODUCT_SN, PRODUCT_PRICE, PRODUCT_QUANTITY, PRODUCT_SKU_ID, PRODUCT_SKU_CODE, PRODUCT_CATEGORY_ID, PROMOTION_NAME, PROMOTION_AMOUNT, COUPON_AMOUNT, INTEGRATION_AMOUNT, REAL_AMOUNT, GIFT_INTEGRATION, GIFT_GROWTH, PRODUCT_ATTR};

    public OrderItemTableDef() {
        super("md_mall_order", "oms_order_item");
    }

    private OrderItemTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public OrderItemTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new OrderItemTableDef("md_mall_order", "oms_order_item", alias));
    }

}
