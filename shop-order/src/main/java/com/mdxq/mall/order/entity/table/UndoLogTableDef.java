package com.mdxq.mall.order.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-08-11
 */
public class UndoLogTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final UndoLogTableDef UNDO_LOG = new UndoLogTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn EXT = new QueryColumn(this, "ext");

    
    public final QueryColumn XID = new QueryColumn(this, "xid");

    
    public final QueryColumn CONTEXT = new QueryColumn(this, "context");

    
    public final QueryColumn BRANCH_ID = new QueryColumn(this, "branch_id");

    
    public final QueryColumn LOG_STATUS = new QueryColumn(this, "log_status");

    
    public final QueryColumn LOG_CREATED = new QueryColumn(this, "log_created");

    
    public final QueryColumn LOG_MODIFIED = new QueryColumn(this, "log_modified");

    
    public final QueryColumn ROLLBACK_INFO = new QueryColumn(this, "rollback_info");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, BRANCH_ID, XID, CONTEXT, ROLLBACK_INFO, LOG_STATUS, LOG_CREATED, LOG_MODIFIED, EXT};

    public UndoLogTableDef() {
        super("md_mall_order", "undo_log");
    }

    private UndoLogTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public UndoLogTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new UndoLogTableDef("md_mall_order", "undo_log", alias));
    }

}
