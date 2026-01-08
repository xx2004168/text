package com.mdxq.mall.user.dto;

import lombok.Data;

@Data
public class ResourceSearchDTO {
    private String nameKeyword;
    private String urlKeyword;
    private Integer categoryId;
}
