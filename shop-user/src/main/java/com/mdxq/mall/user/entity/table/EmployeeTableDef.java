package com.mdxq.mall.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class EmployeeTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final EmployeeTableDef EMPLOYEE = new EmployeeTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    
    public final QueryColumn SALARY = new QueryColumn(this, "salary");

    
    public final QueryColumn DEPARTMENT_ID = new QueryColumn(this, "departmentId");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, SALARY, DEPARTMENT_ID};

    public EmployeeTableDef() {
        super("md_mall_user", "employee");
    }

    private EmployeeTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public EmployeeTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new EmployeeTableDef("md_mall_user", "employee", alias));
    }

}
