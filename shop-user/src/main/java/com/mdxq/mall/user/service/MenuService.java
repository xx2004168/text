package com.mdxq.mall.user.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.mdxq.mall.user.entity.Menu;

import java.util.List;

/**
 *  服务层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
public interface MenuService extends IService<Menu> {
    List<Menu> getTreeList();
}
