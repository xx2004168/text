package com.mdxq.mall.product.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.product.entity.Comment;
import com.mdxq.mall.product.mapper.CommentMapper;
import com.mdxq.mall.product.service.CommentService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>  implements CommentService{

}
