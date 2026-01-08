package com.mdxq.mall.user.controller;

import cn.hutool.core.collection.CollUtil;
import com.mdxq.mall.response.R;
import com.mdxq.mall.user.service.*;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.user.entity.Role;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 添加。
     *
     * @param role 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody Role role) {
        role.setCreateTime(LocalDateTime.now());// 设置创建时间为当前系统时间
        if (roleService.save(role)) {
            return R.ok(true);
        }
        return R.error();
    }

    /**
     * 根据主键删除。
     *
     * @param ids 带批量删除的多个主键,例如：1,2,3
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete")
    public R remove(@RequestParam String ids) {
        // mybatis-flex中用于批量删除多条记录的方法
        // 先把字符串转换成数组，再把数组转成集合
        return R.ok(roleService.removeByIds(Arrays.asList(ids.split(","))));
    }

    /**
     * 根据主键更新。
     *
     * @param role 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@PathVariable Long id, @RequestBody Role role) {
        if (roleService.updateById(role)) {
            return R.ok(true);
        }
        return R.error();
    }

    /**
     * 更新角色的状态
     * @param id 角色ID
     * @param status 更改后的状态
     * @return
     */
    @PostMapping("updateStatus/{id}")
    public R updateStatus(@PathVariable Long id, @RequestParam int status) {
        Role role = roleService.getById(id);
        if (role != null) {
            role.setStatus(status);
            roleService.updateById(role);
            return R.ok(true);
        }
        return R.error();
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public R list() {
        return R.ok(roleService.list());
    }

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleMenuRelationService roleMenuRelationService;

    @GetMapping("listMenu/{roleId}")
    public R listMenu(@PathVariable Long roleId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);// role_id=?
        queryWrapper.select("menu_id");// select menu_id
        List<Long> menuIds = roleMenuRelationService.listAs(queryWrapper, Long.class);// from ums_role_menu_relation
        // 如果这个角色已经分配过菜单，就查询并返回
        if (CollUtil.isNotEmpty(menuIds)) {
            return R.ok(menuService.listByIds(menuIds));
        } else {// 如果这个角色未分配过菜单返回一个空集合
            return R.ok(Collections.emptyList());
        }

    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public Role getInfo(@PathVariable Long id) {
        return roleService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<Role> page, String keyword) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", keyword);
        return R.ok(roleService.page(page, queryWrapper));
    }

    /**
     * 给角色分配有权访问的菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    @PostMapping("allocMenu")
    public R allocMenu(@RequestParam Long roleId, @RequestParam String menuIds) {
        return R.ok(roleService.allocMenu(roleId, menuIds));
    }

    @Autowired
    private RoleResourceRelationService roleResourceRelationService;

    @Autowired
    private ResourceService resourceService;

    /**
     * 查询当前角色对应的资源
     * @param roleId 角色ID
     * @return
     */
    @GetMapping("listResource/{roleId}")
    public R listResource(@PathVariable Long roleId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);
        queryWrapper.select("resource_id");
        List<Long> resourceIds = roleResourceRelationService.listAs(queryWrapper, Long.class);
        if (CollUtil.isNotEmpty(resourceIds)) {
            return R.ok(resourceService.listByIds(resourceIds));
        } else {
            return R.ok(Collections.emptyList());
        }

    }

    /**
     * 分配角色的资源
     * @param roleId 角色ID
     * @param resourceIds 资源ID列表
     * @return
     */
    @PostMapping("allocResource")
    public R allocResource(@RequestParam Long roleId, @RequestParam String resourceIds) {
        return R.ok(roleService.allocResource(roleId, resourceIds));
    }

}
