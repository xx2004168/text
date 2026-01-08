package com.mdxq.mall.product.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  实体类。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "pms_album_pic", schema = "md_mall_product")
public class AlbumPic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    private Long albumId;

    private String pic;

}
