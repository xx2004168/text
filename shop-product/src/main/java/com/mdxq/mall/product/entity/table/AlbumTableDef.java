package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class AlbumTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final AlbumTableDef ALBUM = new AlbumTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn NAME = new QueryColumn(this, "name");

    
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    
    public final QueryColumn COVER_PIC = new QueryColumn(this, "cover_pic");

    
    public final QueryColumn PIC_COUNT = new QueryColumn(this, "pic_count");

    
    public final QueryColumn DESCRIPTION = new QueryColumn(this, "description");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, COVER_PIC, PIC_COUNT, SORT, DESCRIPTION};

    public AlbumTableDef() {
        super("md_mall_product", "pms_album");
    }

    private AlbumTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public AlbumTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new AlbumTableDef("md_mall_product", "pms_album", alias));
    }

}
