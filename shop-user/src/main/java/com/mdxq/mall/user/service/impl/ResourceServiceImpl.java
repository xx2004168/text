package com.mdxq.mall.user.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.entity.Resource;
import com.mdxq.mall.user.mapper.ResourceMapper;
import com.mdxq.mall.user.service.ResourceService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource>  implements ResourceService{

}
