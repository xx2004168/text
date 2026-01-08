package com.mdxq.mall.user.entity;

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
@Table(value = "ums_member_rule_setting", schema = "md_mall_user")
public class MemberRuleSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 连续签到天数
     */
    private Integer continueSignDay;

    /**
     * 连续签到赠送数量
     */
    private Integer continueSignPoint;

    /**
     * 每消费多少元获取1个点
     */
    private Double consumePerPoint;

    /**
     * 最低获取点数的订单金额
     */
    private Double lowOrderAmount;

    /**
     * 每笔订单最高获取点数
     */
    private Integer maxPointPerOrder;

    /**
     * 类型：0->积分规则；1->成长值规则
     */
    private Integer type;

}
