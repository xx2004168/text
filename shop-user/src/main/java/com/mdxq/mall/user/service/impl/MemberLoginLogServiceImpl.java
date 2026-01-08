package com.mdxq.mall.user.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.entity.MemberLoginLog;
import com.mdxq.mall.user.mapper.MemberLoginLogMapper;
import com.mdxq.mall.user.service.MemberLoginLogService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper, MemberLoginLog>  implements MemberLoginLogService{

}
