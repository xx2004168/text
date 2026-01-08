package com.mdxq.mall.sale.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdvertiseDTO {
    private String name;
    private Integer type;
    private LocalDate endTime;
}
