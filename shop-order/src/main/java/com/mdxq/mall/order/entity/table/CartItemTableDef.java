package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class CartItemTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final CartItemTableDef CART_ITEM = new CartItemTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 添加到购物车的价格
     */
    public final QueryColumn PRICE = new QueryColumn(this, "price");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    /**
     * 购买数量
     */
    public final QueryColumn QUANTITY = new QueryColumn(this, "quantity");

    
    public final QueryColumn PRODUCT_ID = new QueryColumn(this, "product_id");

    
    public final QueryColumn PRODUCT_SN = new QueryColumn(this, "product_sn");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_DATE = new QueryColumn(this, "create_date");

    /**
     * 修改时间
     */
    public final QueryColumn MODIFY_DATE = new QueryColumn(this, "modify_date");

    /**
     * 商品主图
     */
    public final QueryColumn PRODUCT_PIC = new QueryColumn(this, "product_pic");

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    public final QueryColumn PRODUCT_ATTR = new QueryColumn(this, "product_attr");

    /**
     * 商品名称
     */
    public final QueryColumn PRODUCT_NAME = new QueryColumn(this, "product_name");

    /**
     * 是否删除
     */
    public final QueryColumn DELETE_STATUS = new QueryColumn(this, "delete_status");

    
    public final QueryColumn PRODUCT_BRAND = new QueryColumn(this, "product_brand");

    
    public final QueryColumn PRODUCT_SKU_ID = new QueryColumn(this, "product_sku_id");

    /**
     * 会员昵称
     */
    public final QueryColumn MEMBER_NICKNAME = new QueryColumn(this, "member_nickname");

    /**
     * 商品sku条码
     */
    public final QueryColumn PRODUCT_SKU_CODE = new QueryColumn(this, "product_sku_code");

    /**
     * 商品副标题（卖点）
     */
    public final QueryColumn PRODUCT_SUB_TITLE = new QueryColumn(this, "product_sub_title");

    /**
     * 商品分类
     */
    public final QueryColumn PRODUCT_CATEGORY_ID = new QueryColumn(this, "product_category_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PRODUCT_ID, PRODUCT_SKU_ID, MEMBER_ID, QUANTITY, PRICE, PRODUCT_PIC, PRODUCT_NAME, PRODUCT_SUB_TITLE, PRODUCT_SKU_CODE, MEMBER_NICKNAME, CREATE_DATE, MODIFY_DATE, DELETE_STATUS, PRODUCT_CATEGORY_ID, PRODUCT_BRAND, PRODUCT_SN, PRODUCT_ATTR};

    public CartItemTableDef() {
        super("md_mall_order", "oms_cart_item");
    }

    private CartItemTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public CartItemTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new CartItemTableDef("md_mall_order", "oms_cart_item", alias));
    }

}
