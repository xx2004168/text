package com.mdxq.mall.user.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.entity.Member;
import com.mdxq.mall.user.mapper.MemberMapper;
import com.mdxq.mall.user.service.MemberService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>  implements MemberService{

}
