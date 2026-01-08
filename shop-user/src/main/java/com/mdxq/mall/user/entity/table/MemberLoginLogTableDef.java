package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberLoginLogTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberLoginLogTableDef MEMBER_LOGIN_LOG = new MemberLoginLogTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn IP = new QueryColumn(this, "ip");

    
    public final QueryColumn CITY = new QueryColumn(this, "city");

    
    public final QueryColumn MEMBER_ID = new QueryColumn(this, "member_id");

    
    public final QueryColumn PROVINCE = new QueryColumn(this, "province");

    /**
     * 登录类型：0->PC；1->android;2->ios;3->小程序
     */
    public final QueryColumn LOGIN_TYPE = new QueryColumn(this, "login_type");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_ID, CREATE_TIME, IP, CITY, LOGIN_TYPE, PROVINCE};

    public MemberLoginLogTableDef() {
        super("md_mall_user", "ums_member_login_log");
    }

    private MemberLoginLogTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberLoginLogTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberLoginLogTableDef("md_mall_user", "ums_member_login_log", alias));
    }

}
