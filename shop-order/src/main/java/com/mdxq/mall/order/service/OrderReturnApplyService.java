package com.mdxq.mall.order.service;

import com.mybatisflex.core.service.IService;
import com.mdxq.mall.order.entity.OrderReturnApply;

import java.util.List;

/**
 *  服务层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public interface OrderReturnApplyService extends IService<OrderReturnApply> {

    boolean removeByIds(List<String> ids, String token);
}
