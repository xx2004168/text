package com.mdxq.mall.user.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


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
@Table(value = "ums_growth_change_history", schema = "md_mall_user")
public class GrowthChangeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    private Long memberId;

    private LocalDateTime createTime;

    /**
     * 改变类型：0->增加；1->减少
     */
    private Integer changeType;

    /**
     * 积分改变数量
     */
    private Integer changeCount;

    /**
     * 操作人员
     */
    private String operateMan;

    /**
     * 操作备注
     */
    private String operateNote;

    /**
     * 积分来源：0->购物；1->管理员修改
     */
    private Integer sourceType;

}
