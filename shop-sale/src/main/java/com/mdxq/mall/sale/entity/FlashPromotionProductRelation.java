package com.mdxq.mall.sale.entity;

import com.mdxq.mall.vo.ProductBaseInfoVo;
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
@Table(value = "sms_flash_promotion_product_relation", schema = "md_mall_sale")
public class FlashPromotionProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    private Long flashPromotionId;

    /**
     * 编号
     */
    private Long flashPromotionSessionId;

    private Long productId;

    /**
     * 限时购价格
     */
    private Double flashPromotionPrice;

    /**
     * 限时购数量
     */
    private Integer flashPromotionCount;

    /**
     * 每人限购数量
     */
    private Integer flashPromotionLimit;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 封装商品的基本信息
     */
    private ProductBaseInfoVo product;

}
