package com.mdxq.mall.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class PersonTableDef extends TableDef {

    public static final PersonTableDef PERSON = new PersonTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn VERSION = new QueryColumn(this, "version");

    public final QueryColumn NICK_NAME = new QueryColumn(this, "nick_name");

    public final QueryColumn REAL_NAME = new QueryColumn(this, "real_name");

    public final QueryColumn ACCOUNT_BALANCE = new QueryColumn(this, "account_balance");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, VERSION, NICK_NAME, REAL_NAME, ACCOUNT_BALANCE};

    public PersonTableDef() {
        super("", "mq_person");
    }

    private PersonTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PersonTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PersonTableDef("", "mq_person", alias));
    }

}
