package com.mdxq.mall.user.service;

import com.mybatisflex.core.service.IService;
import com.mdxq.mall.user.entity.Role;

/**
 *  服务层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public interface RoleService extends IService<Role> {

    /**
     * 给角色分配有权访问的菜单
     * @param roleId 角色ID
     * @param menuIds 菜单ID列表： 例如1,2,3
     * @return
     */
    boolean allocMenu(Long roleId, String menuIds);


    boolean allocResource(Long roleId, String resourceIds);
}
