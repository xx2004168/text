package com.mdxq.mall.user.entity;


import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
// 配置和当前实体类映射的数据表
@Table("employee")
public class Employee {

    // 主键由数据库自动增长
    @Id(keyType = KeyType.Auto)
    private Long id;
    private String name;
    private Integer salary;
    private Integer department;

}
