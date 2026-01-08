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
@Table(value = "pms_feight_template", schema = "md_mall_product")
public class FeightTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    private String name;

    /**
     * 计费类型:0->按重量；1->按件数
     */
    private Integer chargeType;

    /**
     * 首重kg
     */
    private Double firstWeight;

    /**
     * 首费（元）
     */
    private Double firstFee;

    private Double continueWeight;

    private Double continmeFee;

    /**
     * 目的地（省、市）
     */
    private String dest;

}
