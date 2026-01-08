package com.mdxq.mall.order.service;

import com.mybatisflex.core.service.IService;
import com.mdxq.mall.order.entity.OrderReturnReason;

import java.util.List;

/**
 *  服务层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public interface OrderReturnReasonService extends IService<OrderReturnReason> {

    boolean updateStatus(Long ids, int status, String token);

    boolean save(OrderReturnReason orderReturnReason, String token);

    boolean removeByIds(List<Long> ids, String token);

    boolean updateById(OrderReturnReason orderReturnReason, String token);
}
