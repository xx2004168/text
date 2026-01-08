package com.mdxq.mall.order.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.OrderItem;
import com.mdxq.mall.order.mapper.OrderItemMapper;
import com.mdxq.mall.order.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem>  implements OrderItemService{

}
