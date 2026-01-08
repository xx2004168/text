package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberReceiveAddressTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberReceiveAddressTableDef MEMBER_RECEIVE_ADDRESS = new MemberReceiveAddressTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 城市
     */
    public final QueryColumn CITY = new QueryColumn(this, "city");

    /**
     * 收货人名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 区
     */
    public final QueryColumn REGION = new QueryColumn(this, "region");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    /**
     * 邮政编码
     */
    public final QueryColumn POST_CODE = new QueryColumn(this, "post_code");

    /**
     * 省份/直辖市
     */
    public final QueryColumn PROVINCE = new QueryColumn(this, "province");

    
    public final QueryColumn PHONE_NUMBER = new QueryColumn(this, "phone_number");

    /**
     * 是否为默认
     */
    public final QueryColumn DEFAULT_STATUS = new QueryColumn(this, "default_status");

    /**
     * 详细地址(街道)
     */
    public final QueryColumn DETAIL_ADDRESS = new QueryColumn(this, "detail_address");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_ID, NAME, PHONE_NUMBER, DEFAULT_STATUS, POST_CODE, PROVINCE, CITY, REGION, DETAIL_ADDRESS};

    public MemberReceiveAddressTableDef() {
        super("md_mall_user", "ums_member_receive_address");
    }

    private MemberReceiveAddressTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberReceiveAddressTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberReceiveAddressTableDef("md_mall_user", "ums_member_receive_address", alias));
    }

}
