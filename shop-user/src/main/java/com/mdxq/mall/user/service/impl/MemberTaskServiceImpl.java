package com.mdxq.mall.user.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.entity.MemberTask;
import com.mdxq.mall.user.mapper.MemberTaskMapper;
import com.mdxq.mall.user.service.MemberTaskService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class MemberTaskServiceImpl extends ServiceImpl<MemberTaskMapper, MemberTask>  implements MemberTaskService{

}
