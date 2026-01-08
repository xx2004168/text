package com.mdxq.mall.product.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.product.entity.ProductAttributeCategory;
import com.mdxq.mall.product.mapper.ProductAttributeCategoryMapper;
import com.mdxq.mall.product.service.ProductAttributeCategoryService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryMapper, ProductAttributeCategory>  implements ProductAttributeCategoryService{

}
