package com.mdxq.mall.user.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.entity.Permission;
import com.mdxq.mall.user.mapper.PermissionMapper;
import com.mdxq.mall.user.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>  implements PermissionService{

}
