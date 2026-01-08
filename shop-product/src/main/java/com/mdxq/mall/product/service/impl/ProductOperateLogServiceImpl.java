package com.mdxq.mall.product.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.product.entity.ProductOperateLog;
import com.mdxq.mall.product.mapper.ProductOperateLogMapper;
import com.mdxq.mall.product.service.ProductOperateLogService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class ProductOperateLogServiceImpl extends ServiceImpl<ProductOperateLogMapper, ProductOperateLog>  implements ProductOperateLogService{

}
