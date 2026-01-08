package com.mdxq.mall.product.service;

import com.mybatisflex.core.service.IService;
import com.mdxq.mall.product.entity.ProductCategory;

import java.util.List;

/**
 *  服务层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    List<ProductCategory> listwithChildren();

//    List<ProductCategory> withChildren(ProductCategory productCategory);
}
