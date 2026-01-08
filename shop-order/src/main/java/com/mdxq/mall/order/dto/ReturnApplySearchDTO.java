package com.mdxq.mall.order.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ReturnApplySearchDTO {
    private Long id;
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime;
    private String handleMan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate handleTime;
}
