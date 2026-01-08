package com.mdxq.mall.product.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.product.entity.Album;
import com.mdxq.mall.product.mapper.AlbumMapper;
import com.mdxq.mall.product.service.AlbumService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album>  implements AlbumService{

}
