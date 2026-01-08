package com.mdxq.mall.user.controller;

import com.mdxq.mall.response.R;
import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.user.entity.ResourceCategory;
import com.mdxq.mall.user.service.ResourceCategoryService;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/resourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    /**
     * 添加。
     *
     * @param resourceCategory 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody ResourceCategory resourceCategory) {
        resourceCategory.setCreateTime(LocalDateTime.now());
        return R.ok(resourceCategoryService.save(resourceCategory));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(resourceCategoryService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param resourceCategory 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PostMapping("update/{id}")
    public R update(@RequestBody ResourceCategory resourceCategory) {
        return R.ok(resourceCategoryService.updateById(resourceCategory));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public R list() {
        return R.ok(resourceCategoryService.list());
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public ResourceCategory getInfo(@PathVariable Long id) {
        return resourceCategoryService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<ResourceCategory> page) {
        return R.ok(resourceCategoryService.page(page));
    }

}
