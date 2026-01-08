package com.mdxq.mall.user.controller;

import cn.hutool.core.util.StrUtil;
import com.mdxq.mall.response.R;
import com.mdxq.mall.user.dto.ResourceSearchDTO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdxq.mall.user.entity.Resource;
import com.mdxq.mall.user.service.ResourceService;

import java.time.LocalDateTime;
import java.util.List;

/**
 *  控制层。
 *
 * @author XuXin
 * @since 2025-01-12
 */
@RestController
@RequestMapping("/api/v1/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 添加。
     *
     * @param resource 
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    public R save(@RequestBody Resource resource) {
        resource.setCreateTime(LocalDateTime.now());
        return R.ok(resourceService.save(resource));
    }

    /**
     * 根据主键删除。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("delete/{id}")
    public R remove(@PathVariable Long id) {
        return R.ok(resourceService.removeById(id));
    }

    /**
     * 根据主键更新。
     *
     * @param resource 
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update/{id}")
    public R update(@RequestBody Resource resource) {
        return R.ok(resourceService.updateById(resource));
    }

    /**
     * 查询所有。
     *
     * @return 所有数据
     */
    @GetMapping(value = {"list","listAll"})
    public R list() {
        return R.ok(resourceService.list());
    }

    /**
     * 根据主键获取详细信息。
     *
     * @param id 主键
     * @return 详情
     */
    @GetMapping("getInfo/{id}")
    public Resource getInfo(@PathVariable Long id) {
        return resourceService.getById(id);
    }

    /**
     * 分页查询。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public R page(Page<Resource> page, ResourceSearchDTO dto) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StrUtil.isNotBlank(dto.getNameKeyword())) {
            queryWrapper.eq("name", dto.getNameKeyword());
        }
        if (StrUtil.isNotBlank(dto.getUrlKeyword())) {
            queryWrapper.eq("url", dto.getUrlKeyword());
        }
        if (dto.getCategoryId() != null) {
            queryWrapper.eq("category_id", dto.getCategoryId());
        }

        return R.ok(resourceService.page(page,queryWrapper));
    }

}
