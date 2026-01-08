package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class AdminTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final AdminTableDef ADMIN = new AdminTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 头像
     */
    public final QueryColumn ICON = new QueryColumn(this, "icon");

    /**
     * 备注信息
     */
    public final QueryColumn NOTE = new QueryColumn(this, "note");

    /**
     * 邮箱
     */
    public final QueryColumn EMAIL = new QueryColumn(this, "email");

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 昵称
     */
    public final QueryColumn NICK_NAME = new QueryColumn(this, "nick_name");

    
    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    
    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    /**
     * 最后登录时间
     */
    public final QueryColumn LOGIN_TIME = new QueryColumn(this, "login_time");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, USERNAME, PASSWORD, ICON, EMAIL, NICK_NAME, NOTE, CREATE_TIME, LOGIN_TIME, STATUS};

    public AdminTableDef() {
        super("md_mall_user", "ums_admin");
    }

    private AdminTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public AdminTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new AdminTableDef("md_mall_user", "ums_admin", alias));
    }

}
