package com.mdxq.mall.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "mq_person")
public class Person implements Serializable {
    @Id(keyType = KeyType.Auto)
    private Integer id;
    private String nickName;
    private String realName;
    private Float accountBalance;
    private Integer version;
}
