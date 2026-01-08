package com.mdxq.mall.order.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.OrderOperateHistory;
import com.mdxq.mall.order.mapper.OrderOperateHistoryMapper;
import com.mdxq.mall.order.service.OrderOperateHistoryService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistory>  implements OrderOperateHistoryService{

}
