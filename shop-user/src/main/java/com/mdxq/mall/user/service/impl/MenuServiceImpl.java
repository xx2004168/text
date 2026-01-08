package com.mdxq.mall.user.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.mdxq.mall.user.entity.Menu;
import com.mdxq.mall.user.mapper.MenuMapper;
import com.mdxq.mall.user.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务层实现。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>  implements MenuService{

    @Override
    public List<Menu> getTreeList() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("level", 0);
        queryWrapper.ne("hidden", 1);
        List<Menu> level0Menus = this.list(queryWrapper);// 查到所有的0级菜单
        for (Menu menu0 : level0Menus) {
            queryWrapper.clear();// 先将原有的条件清除掉
            queryWrapper.eq("parent_id", menu0.getId());// 根据父ID查子菜单
            queryWrapper.ne("hidden", 1);
            menu0.setChildren(this.list(queryWrapper));
        }
        return level0Menus;
    }
}
