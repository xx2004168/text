package com.mdxq.mall.user.controller;

import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.user.entity.Menu;
import com.mdxq.mall.user.service.MenuService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 添加。
     *
     * @param menu 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody Menu menu) {
        if (menu.getParentId() == 0) {
            menu.setLevel(0);
        } else {
            menu.setLevel(1);
        }
        return R.ok(menuService.save(menu));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(menuService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param menu 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@RequestBody Menu menu) {
        if (menu.getParentId() == 0) {
            menu.setLevel(0);
        } else {
            menu.setLevel(1);
        }
        return R.ok(menuService.updateById(menu));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list/{parentId}")
    public R list(@PathVariable Long parentId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", parentId);
        return R.ok(menuService.list(queryWrapper));
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public R getInfo(@PathVariable Long id) {
        return R.ok(menuService.getById(id));
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page/{parentId}")
    public R page(Page<Menu> page, @PathVariable Long parentId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (parentId != 0) {
            queryWrapper.eq("parent_id", parentId);
        }
        return R.ok(menuService.page(page, queryWrapper));
    }

    @GetMapping("treeList")
    public R fetchTreeList() {
        /*QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("level", 0);
        queryWrapper.ne("hidden", 1);
        List<Menu> level0Menus = menuService.list(queryWrapper);// 查到所有的0级菜单
        for (Menu menu0 : level0Menus) {
            queryWrapper.clear();// 先将原有的条件清除掉
            queryWrapper.eq("parent_id", menu0.getId());// 根据父ID查子菜单
            queryWrapper.ne("hidden", 1);
            menu0.setChildren(menuService.list(queryWrapper));
        }*/
        List<Menu> level0Menus = menuService.getTreeList();
        return R.ok(level0Menus);
    }

    @PostMapping("updateHidden/{id}")
    public R updateHidden(@PathVariable Long id, @RequestParam int hidden) {
        Menu menu = menuService.getById(id);
        menu.setHidden(hidden);
        menuService.updateById(menu);
        return R.ok(true);
    }

}
