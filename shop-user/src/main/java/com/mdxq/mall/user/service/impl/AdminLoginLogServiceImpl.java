package com.mdxq.mall.user.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.entity.AdminLoginLog;
import com.mdxq.mall.user.mapper.AdminLoginLogMapper;
import com.mdxq.mall.user.service.AdminLoginLogService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class AdminLoginLogServiceImpl extends ServiceImpl<AdminLoginLogMapper, AdminLoginLog>  implements AdminLoginLogService{

}
