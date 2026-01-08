package com.mdxq.mall.product.dto;

import lombok.Data;

@Data
public class ProductSearchDTO {
    private String keyword;
    private Integer publishStatus;
    private Integer verifyStatus;
    private Long productSn;
    private Long productCategoryId;
    private Long brandId;
}
