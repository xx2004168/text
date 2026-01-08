package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class MemberTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final MemberTableDef MEMBER = new MemberTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 职业
     */
    public final QueryColumn JOB = new QueryColumn(this, "job");

    /**
     * 所做城市
     */
    public final QueryColumn CITY = new QueryColumn(this, "city");

    /**
     * 头像
     */
    public final QueryColumn ICON = new QueryColumn(this, "icon");

    /**
     * 手机号码
     */
    public final QueryColumn PHONE = new QueryColumn(this, "phone");

    /**
     * 性别：0->未知；1->男；2->女
     */
    public final QueryColumn GENDER = new QueryColumn(this, "gender");

    /**
     * 成长值
     */
    public final QueryColumn GROWTH = new QueryColumn(this, "growth");

    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 生日
     */
    public final QueryColumn BIRTHDAY = new QueryColumn(this, "birthday");

    /**
     * 昵称
     */
    public final QueryColumn NICKNAME = new QueryColumn(this, "nickname");

    /**
     * 密码
     */
    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    /**
     * 用户名
     */
    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    /**
     * 注册时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 用户来源
     */
    public final QueryColumn SOURCE_TYPE = new QueryColumn(this, "source_type");

    /**
     * 积分
     */
    public final QueryColumn INTEGRATION = new QueryColumn(this, "integration");

    /**
     * 剩余抽奖次数
     */
    public final QueryColumn LUCKEY_COUNT = new QueryColumn(this, "luckey_count");

    
    public final QueryColumn MEMBER_LEVEL_ID = new QueryColumn(this, "member_level_id");

    /**
     * 历史积分数量
     */
    public final QueryColumn HISTORY_INTEGRATION = new QueryColumn(this, "history_integration");

    /**
     * 个性签名
     */
    public final QueryColumn PERSONALIZED_SIGNATURE = new QueryColumn(this, "personalized_signature");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, MEMBER_LEVEL_ID, USERNAME, PASSWORD, NICKNAME, PHONE, STATUS, CREATE_TIME, ICON, GENDER, BIRTHDAY, CITY, JOB, PERSONALIZED_SIGNATURE, SOURCE_TYPE, INTEGRATION, GROWTH, LUCKEY_COUNT, HISTORY_INTEGRATION};

    public MemberTableDef() {
        super("md_mall_user", "ums_member");
    }

    private MemberTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public MemberTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new MemberTableDef("md_mall_user", "ums_member", alias));
    }

}
