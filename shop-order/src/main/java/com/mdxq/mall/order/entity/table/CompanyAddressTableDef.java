package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class CompanyAddressTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final CompanyAddressTableDef COMPANY_ADDRESS = new CompanyAddressTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 市
     */
    public final QueryColumn CITY = new QueryColumn(this, "city");

    /**
     * 收发货人姓名
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 收货人电话
     */
    public final QueryColumn PHONE = new QueryColumn(this, "phone");

    /**
     * 区
     */
    public final QueryColumn REGION = new QueryColumn(this, "region");

    /**
     * 省/直辖市
     */
    public final QueryColumn PROVINCE = new QueryColumn(this, "province");

    /**
     * 默认发货地址：0->否；1->是
     */
    public final QueryColumn SEND_STATUS = new QueryColumn(this, "send_status");

    /**
     * 地址名称
     */
    public final QueryColumn ADDRESS_NAME = new QueryColumn(this, "address_name");

    /**
     * 详细地址
     */
    public final QueryColumn DETAIL_ADDRESS = new QueryColumn(this, "detail_address");

    /**
     * 是否默认收货地址：0->否；1->是
     */
    public final QueryColumn RECEIVE_STATUS = new QueryColumn(this, "receive_status");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ADDRESS_NAME, SEND_STATUS, RECEIVE_STATUS, NAME, PHONE, PROVINCE, CITY, REGION, DETAIL_ADDRESS};

    public CompanyAddressTableDef() {
        super("md_mall_order", "oms_company_address");
    }

    private CompanyAddressTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public CompanyAddressTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new CompanyAddressTableDef("md_mall_order", "oms_company_address", alias));
    }

}
