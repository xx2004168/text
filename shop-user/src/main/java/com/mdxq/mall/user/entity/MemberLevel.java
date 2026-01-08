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
@Table(value = "ums_member_level", schema = "md_mall_user")
public class MemberLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    private String name;

    private Integer growthPoint;

    /**
     * 是否为默认等级：0->不是；1->是
     */
    private Integer defaultStatus;

    /**
     * 免运费标准
     */
    private Double freeFreightPoint;

    /**
     * 每次评价获取的成长值
     */
    private Integer commentGrowthPoint;

    /**
     * 是否有免邮特权
     */
    private Integer priviledgeFreeFreight;

    /**
     * 是否有签到特权
     */
    private Integer priviledgeSignIn;

    /**
     * 是否有评论获奖励特权
     */
    private Integer priviledgeComment;

    /**
     * 是否有专享活动特权
     */
    private Integer priviledgePromotion;

    /**
     * 是否有会员价格特权
     */
    private Integer priviledgeMemberPrice;

    /**
     * 是否有生日特权
     */
    private Integer priviledgeBirthday;

    private String note;

}
