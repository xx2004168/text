package com.mdxq.mall.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.user.entity.*;
import com.mdxq.mall.user.mapper.RoleMenuRelationMapper;
import com.mdxq.mall.user.service.ResourceCategoryService;
import com.mdxq.mall.user.service.RoleResourceRelationService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.mapper.RoleMapper;
import com.mdxq.mall.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>  implements RoleService{

    @Autowired
    private RoleMenuRelationMapper relationMapper;

    @Override
    @Transactional// 事务声明的注解，所有的数据库操作（满足原子性）要么都成功要么都失败
    public boolean allocMenu(Long roleId, String menuIds) {
        // 先删除已有的
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);
        relationMapper.deleteByQuery(queryWrapper);
        //在批量插入本次的
        if (StrUtil.isNotBlank(menuIds)) {
            List<RoleMenuRelation> relationList = new ArrayList<>();
            for (String menuId : menuIds.split(",")) {
                // 向List中添加数据
                relationList.add(new RoleMenuRelation(null, roleId, Long.valueOf(menuId)));
            }
            relationMapper.insertBatch(relationList);
        }
        return true;
    }

    @Autowired
    private RoleResourceRelationService roleResourceRelationService;

    @Override
    @Transactional
    public boolean allocResource(Long roleId, String resourceIds) {
        QueryWrapper queryWrapper = new QueryWrapper();
        // 以下两条语句是为了删除role_id下的所有记录
        queryWrapper.eq("role_id", roleId);
        roleResourceRelationService.remove(queryWrapper);
        if (StrUtil.isNotBlank(resourceIds)) {
            List<RoleResourceRelation> relationList = new ArrayList<>();
            for (String resource : resourceIds.split(",")) {
                relationList.add(new RoleResourceRelation(null,roleId,Long.valueOf(resource)));
            }
            roleResourceRelationService.saveBatch(relationList);
        }
        return true;
    }



}
