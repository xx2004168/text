package com.mdxq.mall.order.service;

import com.mdxq.mall.order.dto.UpdateDeliveryDTO;
import com.mdxq.mall.order.dto.UpdateNodeDTO;
import com.mybatisflex.core.service.IService;
import com.mdxq.mall.order.entity.Order;

import java.util.List;

/**
 *  服务层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public interface OrderService extends IService<Order> {

    /**
     * 修改订单（收件人信息）
     * @param order 订单数据
     * @param token 携带管理员信息的令牌
     * @return
     */
    boolean updateReceiverInfo(Order order, String token);

    /**
     * 修改订单备注
     * @param dto 保存了订单ID、状态和备注内容
     * @param token 携带管理员信息的令牌
     * @return
     */
    boolean updateNote(UpdateNodeDTO dto, String token);

    boolean updateDelivery(List<UpdateDeliveryDTO> dtoList, String token);

    /**
     * 批量删除订单
     * @param idList
     * @param token
     * @return
     * @param
     */
    boolean removeByIds(List<String> idList, String token);

    boolean updateClose(List<Long> ids, String note, String token);
}
