package com.mdxq.mall.order.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.OrderSetting;
import com.mdxq.mall.order.mapper.OrderSettingMapper;
import com.mdxq.mall.order.service.OrderSettingService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting>  implements OrderSettingService{

}
