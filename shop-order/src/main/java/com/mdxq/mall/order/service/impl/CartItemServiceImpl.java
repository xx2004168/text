package com.mdxq.mall.order.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.CartItem;
import com.mdxq.mall.order.mapper.CartItemMapper;
import com.mdxq.mall.order.service.CartItemService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem>  implements CartItemService{

}
