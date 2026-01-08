package com.mdxq.mall.product.service;

import com.mybatisflex.core.service.IService;
import com.mdxq.mall.product.entity.Product;

/**
 *  服务层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public interface ProductService extends IService<Product> {

    /**
     * 新增一个更新商品库存的方法
     * @param id
     * @param num
     * @return
     */
    boolean updateStock(Long id, Integer num);

}
