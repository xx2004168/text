package com.mdxq.mall.product.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.product.entity.ProductAttribute;
import com.mdxq.mall.product.mapper.ProductAttributeMapper;
import com.mdxq.mall.product.service.ProductAttributeService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class ProductAttributeServiceImpl extends ServiceImpl<ProductAttributeMapper, ProductAttribute>  implements ProductAttributeService{

}
