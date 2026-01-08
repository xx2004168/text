package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class AdminLoginLogTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final AdminLoginLogTableDef ADMIN_LOGIN_LOG = new AdminLoginLogTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn IP = new QueryColumn(this, "ip");

    
    public final QueryColumn ADDRESS = new QueryColumn(this, "address");

    
    public final QueryColumn ADMIN_ID = new QueryColumn(this, "admin_id");

    /**
     * 浏览器登录类型
     */
    public final QueryColumn USER_AGENT = new QueryColumn(this, "user_agent");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ADMIN_ID, CREATE_TIME, IP, ADDRESS, USER_AGENT};

    public AdminLoginLogTableDef() {
        super("md_mall_user", "ums_admin_login_log");
    }

    private AdminLoginLogTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public AdminLoginLogTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new AdminLoginLogTableDef("md_mall_user", "ums_admin_login_log", alias));
    }

}
