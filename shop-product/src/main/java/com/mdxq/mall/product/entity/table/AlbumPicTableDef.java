package com.mdxq.mall.product.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;


/**
 *  表定义层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public class AlbumPicTableDef extends TableDef {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final AlbumPicTableDef ALBUM_PIC = new AlbumPicTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn PIC = new QueryColumn(this, "pic");

    
    public final QueryColumn ALBUM_ID = new QueryColumn(this, "album_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ALBUM_ID, PIC};

    public AlbumPicTableDef() {
        super("md_mall_product", "pms_album_pic");
    }

    private AlbumPicTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public AlbumPicTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new AlbumPicTableDef("md_mall_product", "pms_album_pic", alias));
    }

}
