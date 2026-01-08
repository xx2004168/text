package com.mdxq.mall.order.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.order.entity.CompanyAddress;
import com.mdxq.mall.order.mapper.CompanyAddressMapper;
import com.mdxq.mall.order.service.CompanyAddressService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class CompanyAddressServiceImpl extends ServiceImpl<CompanyAddressMapper, CompanyAddress>  implements CompanyAddressService{

}
